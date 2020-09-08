package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class DSquirrelMerchant {


    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.ints();
        int[][] a = in.ints(2, 3);
        n = solve((int) n, a[0], a[1]);
        n = solve((int) n, a[1], a[0]);
        out.ans(n).ln();
    }

    private static final long[] dp = new long[25_000_001];

    private static long solve(int n, int[] from, int[] to) {
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            long res = i;
            for (int j = 0; j < 3; j++) {
                if (i < from[j] || from[j] >= to[j]) continue;
                res = Math.max(res, dp[i - from[j]] + to[j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
