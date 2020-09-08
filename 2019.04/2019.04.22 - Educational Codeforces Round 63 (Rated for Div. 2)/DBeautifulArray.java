package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.stream.LongStream;

public class DBeautifulArray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int x = in.ints();
        long[] a = in.longs(n);
        long[][] dp = new long[3][n + 1];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = Math.max(dp[0][i] + a[i], 0);
            dp[1][i + 1] = Math.max(dp[1][i] + a[i] * x, Math.max(dp[0][i] + a[i] * x, 0));
            dp[2][i + 1] = Math.max(dp[2][i] + a[i], Math.max(dp[1][i] + a[i], 0));
            ans = IntMath.max(ans, dp[0][i + 1], dp[1][i + 1], dp[2][i + 1]);
        }
        out.ans(ans).ln();
    }
}
