package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class AIvanTheFoolAndTheProbabilityTheory {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long[] dp = new long[100003];
        dp[0] = 1;
        for (int i = 0; i <= 100000; i++) {
            dp[i + 1] += dp[i];
            dp[i + 2] += dp[i];
            dp[i + 1] %= MOD;
            dp[i + 2] %= MOD;
        }
        //System.out.println(Arrays.toString(Arrays.copyOf(dp, 10)));
        out.ans((dp[n] + dp[m] + MOD - 1) * 2 % MOD).ln();
    }
}
