package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.FFT;
import dev.mikit.atcoder.lib.math.NTT;
import dev.mikit.atcoder.lib.structure.sparsetable.SparseTable;

import java.util.Arrays;

public class FKnapsackForAllSegments {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter out) {
        int n = in.ints(), s = in.ints();
        int[] a = in.ints(n);
        long[][][] dp = new long[3][s + 1][n + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[0][j][i + 1] += dp[0][j][i];
                dp[1][j][i + 1] += dp[0][j][i];
                dp[1][j][i + 1] += dp[1][j][i];
                dp[2][j][i + 1] += dp[0][j][i];
                dp[2][j][i + 1] += dp[1][j][i];
                dp[2][j][i + 1] += dp[2][j][i];
                dp[0][j][i + 1] %= MOD;
                dp[1][j][i + 1] %= MOD;
                dp[2][j][i + 1] %= MOD;
                if (j + a[i] <= s) {
                    dp[1][j + a[i]][i + 1] += dp[0][j][i];
                    dp[2][j + a[i]][i + 1] += dp[0][j][i];
                    dp[1][j + a[i]][i + 1] += dp[1][j][i];
                    dp[2][j + a[i]][i + 1] += dp[1][j][i];
                }
            }
        }
        out.ans(dp[2][s][n] % MOD).ln();
    }
}
