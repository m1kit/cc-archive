package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDigitsParade {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        long[][] dp = new long[13][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 13; j++) {
                if (s.charAt(i) == '?') {
                    for (int k = 0; k < 10; k++) {
                        int dest = (10 * j + k) % 13;
                        dp[dest][i + 1] += dp[j][i];
                        dp[dest][i + 1] %= MOD;
                    }
                } else {
                    int dig = s.charAt(i) - '0';
                    dp[(10 * j + dig) % 13][i + 1] = dp[j][i];
                }
            }
        }

        out.ans(dp[5][n]).ln();
    }
}
