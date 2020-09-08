package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class NSlimes {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long[] sum = IntMath.sum(a);
        long[][] dp = new long[n][n + 1];
        ArrayUtil.fill(dp, INF);
        for (int i = 0; i < n; i++) dp[i][i + 1] = 0;
        for (int len = 2; len <= n; len++) {
            for (int s = 0, g = len; g <= n; s++, g++) {
                for (int m = s + 1; m < g; m++) {
                    dp[s][g] = Math.min(dp[s][g], dp[s][m] + dp[m][g] + sum[g] - sum[s]);
                }
            }
        }
        out.ans(dp[0][n]).ln();
    }
}
