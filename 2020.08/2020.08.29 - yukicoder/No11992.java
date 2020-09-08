package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class No11992 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), m = in.ints();
        long[][] a = in.longs(n, m);
        long[][] dp = new long[2][n + 1];
        dp[1][0] = -1_000_000_000_000_000L;
        for (int i = 0; i < n; i++) {
            long t = 0;
            for (int j = 0; j < m; j++) t += a[i][j];
            dp[0][i + 1] = Math.max(dp[0][i], dp[1][i] - t);
            dp[1][i + 1] = Math.max(dp[1][i], dp[0][i] + t);
        }
        out.ans(dp[1][n]).ln();
    }
}
