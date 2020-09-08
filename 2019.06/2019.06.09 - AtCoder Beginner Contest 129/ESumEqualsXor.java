package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class ESumEqualsXor {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        ModMath mod = new ModMath(MOD);
        int n = s.length();
        long[][] dp = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 2;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                dp[i][1] = (dp[i - 1][1] * 2) % MOD;
                dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1]) % MOD;
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = (dp[i - 1][0] * 3) % MOD;
            }
        }
        out.ans((dp[n - 1][0] + dp[n - 1][1]) % MOD).ln();
    }
}
