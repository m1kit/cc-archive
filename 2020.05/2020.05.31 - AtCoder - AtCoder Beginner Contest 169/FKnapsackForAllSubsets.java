package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.Arrays;

public class FKnapsackForAllSubsets {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), s = in.ints();
        int[] a = in.ints(n);
        long[][] dp = new long[n + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int x = 0; x <= s; x++) {
                dp[i + 1][x] = 2 * dp[i][x] % MOD;
                if (x >= a[i]) dp[i + 1][x] += dp[i][x - a[i]];
                dp[i + 1][x] %= MOD;
            }
        }
        out.ans(dp[n][s]).ln();
    }
}
