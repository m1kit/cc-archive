package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class EPayment {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.chars();
        int n = s.length;
        for (int i = 0; i < n; i++) s[i] -= '0';
        long[][] dp = new long[2][n + 1];
        ArrayUtil.fill(dp, Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = Math.min(dp[0][i + 1], dp[0][i] + s[i]);
            dp[0][i + 1] = Math.min(dp[0][i + 1], dp[1][i] + s[i] + 1);
            dp[1][i + 1] = Math.min(dp[1][i + 1], dp[0][i] + (10 - s[i]));
            dp[1][i + 1] = Math.min(dp[1][i + 1], dp[1][i] + (9 - s[i]));
        }
        out.ans(Math.min(dp[0][n], dp[1][n] + 1)).ln();
    }
}
