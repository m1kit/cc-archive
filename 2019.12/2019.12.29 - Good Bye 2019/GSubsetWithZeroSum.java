package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GSubsetWithZeroSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        //out = new LightWriter(new BufferedOutputStream(System.out));
        int testCases = in.ints();
        int[] ans = new int[1_000_000];
        int[] b = new int[1_000_000];
        boolean[] visited = new boolean[1_000_000];

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            for (int i = 0; i < n; i++) {
                b[i] = i - in.ints();
            }

            if (n == 1) {
                out.print("1\n1\n");
                continue;
            }

            int len = 0;
            for (int i = 0; i < n; i++) {
                visited[i] = false;
            }

            int cur = 0, start = -1;
            while (len <= n){
                if (visited[cur]) {
                    start = cur;
                    break;
                }
                visited[cur] = true;
                ans[len++] = cur;
                cur = b[cur];
            }

            if (start == -1) throw new RuntimeException();

            int startIndex = 0;
            while (ans[startIndex] != start) startIndex++;
            out.ans(len - startIndex).ln();
            for (int i = startIndex; i < len; i++) out.ans(ans[i] + 1);
            out.ln();
        }
        out.flush();
    }
}
