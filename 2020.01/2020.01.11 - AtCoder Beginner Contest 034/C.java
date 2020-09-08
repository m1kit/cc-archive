package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n),  dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + Math.abs(a[i] - a[i + 1]));
            if (i == n - 2) continue;
            dp[i + 2] = Math.min(dp[i + 2], dp[i] + Math.abs(a[i] - a[i + 2]));
        }
        out.ans(dp[n - 1]).ln();
    }
}
