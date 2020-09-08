package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class ParentingPartneringReturns {

    private static final int INF = 200000;

    private static Comparator<Task> START_INC = Comparator.comparing(task -> task.s);
    private static Comparator<Task> END_INC = Comparator.comparing(task -> task.e);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        loop:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase);
            int n = in.ints();
            Task[] ans = new Task[n];
            for (int i = 0; i < n; i++) ans[i] = new Task(in.ints(), in.ints());
            Task[] tasks = ans.clone();
            IntroSort.sort(tasks, END_INC.thenComparing(START_INC));

            int[] dp = new int[n];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            tasks[0].ans = 'C';

            for (int i = 1; i < n; i++) {
                if (tasks[i - 1].e <= tasks[i].s) dp[i] = Math.min(dp[i], dp[i - 1]);
                if (dp[i - 1] <= tasks[i].s) dp[i] = Math.min(dp[i], tasks[i - 1].e);
                if (dp[i] == INF) {
                    out.ans("IMPOSSIBLE").ln();
                    continue loop;
                }
            }

            for (int i = 1; i < n; i++) {
                if (dp[i] == dp[i - 1]) tasks[i].ans = tasks[i - 1].ans;
                else tasks[i].ans = not(tasks[i - 1].ans);
            }
            for (int i = 0; i < n; i++) out.print(ans[i].ans);
            out.ln();
        }
    }

    private static char not(char c) {
        return c == 'C' ? 'J' : 'C';
    }

    private static class Task {
        int s, e;
        char ans;

        Task(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
