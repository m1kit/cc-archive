package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class LDeque {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = a[i];
            for (int j = 0; j < i; j++) {
                dp[i][j] = -(1L << 54);
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; i + j <= n; j++) {
                dp[j][i + j - 1] = Math.max(a[j] - dp[j + 1][i + j - 1], a[i + j - 1] - dp[j][i + j - 2]);
            }
        }
        out.ansln(dp[0][n - 1]);
    }
}
