package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class No1066RedAndBlueAndMoreVariousColorsEasy {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        long[][] dp = new long[2][n + 1];
        dp[1][0] = 1;
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            System.arraycopy(dp[1], 0, dp[0], 0, n + 1);
            for (int j = 0; j <= n; j++) {
                dp[1][j] *= (a - 1);
                if (0 < j) dp[1][j] += dp[0][j - 1];
                dp[1][j] %= MOD;
            }
        }
        for (int i = 0; i < q; i++) out.ans(dp[1][in.ints()]).ln();
    }
}
