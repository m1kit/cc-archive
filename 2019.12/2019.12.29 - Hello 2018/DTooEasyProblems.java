package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DTooEasyProblems {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long t = in.longs();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) tasks[i] = new Task(i, in.longs(), in.longs());
        IntroSort.sort(tasks, Comparator.comparing(task -> task.t));

        int min = 0, max = n + 1;
        while (max - min > 1) {
            int mid = (min + max) / 2, count = 0;
            long cost = 0;
            for (int i = 0; i < n && count < mid; i++) {
                if (tasks[i].a < mid) continue;
                cost += tasks[i].t;
                count++;
            }
            if (count == mid && cost <= t) min = mid;
            else max = mid;
        }

        int score = min;
        out.ans(score).ln().ans(score).ln();
        IntroSort.sort(tasks, Comparator.comparing(task -> task.a >= score ? task.t : Integer.MAX_VALUE));
        for (int i = 0; i < score; i++) out.ans(tasks[i].i + 1);
        out.ln();
    }

    private static class Task {
        long i, a, t;

        public Task(int i, long a, long t) {
            this.i = i;
            this.a = a;
            this.t = t;
        }
    }
}
