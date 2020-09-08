package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class H {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), l = in.ints();
        boolean[] obstacle = new boolean[l + 1];
        long[] dp = new long[l + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) obstacle[in.ints()] = true;
        int t1 = in.ints(), t2 = in.ints(), t3 = in.ints();
        dp[0] = 0;
        for (int i = 1; i <= l; i++) {
            dp[i] = dp[i - 1] + t1;
            if (2 <= i) dp[i] = Math.min(dp[i], dp[i - 2] + t1 + t2);
            if (4 <= i) dp[i] = Math.min(dp[i], dp[i - 4] + t1 + t2 + t2 + t2);
            if (obstacle[i]) dp[i] += t3;
        }
        long ans = dp[l];
        if (1 <= l) ans = Math.min(ans, dp[l - 1] + (t1 + t2) / 2);
        if (2 <= l) ans = Math.min(ans, dp[l - 2] + (t1 + 3 * t2) / 2);
        if (3 <= l) ans = Math.min(ans, dp[l - 3] + (t1 + 5 * t2) / 2);
        out.ans(ans).ln();
    }
}
