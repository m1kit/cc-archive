package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADividingAString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        int n = s.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < n; i++) {
            // Take 1
            dp[0][i + 1] = dp[1][i] + 1;
            if (i >= 1 && s.charAt(i - 1) != s.charAt(i)) dp[0][i + 1] = Math.max(dp[0][i + 1], dp[0][i] + 1);
            // Take 2
            if (i >= 1) {
                dp[1][i + 1] = dp[0][i - 1] + 1;
                if (i >= 3 && (s.charAt(i) != s.charAt(i - 2) || s.charAt(i - 1) != s.charAt(i - 3))) {
                    dp[1][i + 1] = Math.max(dp[1][i + 1], dp[1][i - 1] + 1);
                }
            }
        }
        out.ans(Math.max(dp[0][n], dp[1][n])).ln();
    }
}
