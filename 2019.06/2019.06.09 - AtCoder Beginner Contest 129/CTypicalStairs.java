package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.Set;

public class CTypicalStairs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Set<Integer> danger = new HashSet<>();
        for (int i = 0; i < m; i++) {
            danger.add(in.ints());
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (danger.contains(i)) continue;
            if (i >= 2) dp[i] = dp[i - 2];
            dp[i] += dp[i - 1];
            dp[i] %= MOD;
        }
        out.ans(dp[n]).ln();
    }
}
