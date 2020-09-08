package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class OMatching {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), all = 1 << n;
        int[][] a = in.ints(n, n);

        long[] dp = new long[all];
        dp[0] = 1;
        for (int j = 0; j < all - 1; j++) {
            int i = Integer.bitCount(j);
            for (int k = 0; k < n; k++) {
                int b = 1 << k;
                if (a[i][k] == 0 || (b & j) != 0) continue;
                dp[b | j] += dp[j];
                if (dp[b | j] >= MOD) dp[b | j] -= MOD;
            }
        }
        out.ans(dp[all - 1]).ln();
    }
}
