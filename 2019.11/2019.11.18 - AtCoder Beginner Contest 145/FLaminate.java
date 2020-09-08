package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class FLaminate {

    private static final long INF = (long) 1e15;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] h = new long[n + 1];
        for (int i = 0; i < n; i++) h[i + 1] = in.longs();

        long[][] dp = new long[1][n + 1];
        ArrayUtil.fill(dp, INF);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            long[][] dp2 = new long[i + 1][n + 1];
            for (int j = 0; j < i; j++) {
                dp2[j][0] = INF;
                System.arraycopy(dp[j], 0, dp2[j], 1, n);
            }
            Arrays.fill(dp2[i], INF);

            for (int j = 0; j < i; j++) {
                for (int l = 0; l <= n; l++) {
                    dp2[i][l] = Math.min(dp2[i][l], dp[j][l] + Math.max(0, h[i] - h[j]));
                }
            }
            dp = dp2;
        }
        long ans = INF;
        for (int i = 0; i <= n; i++) ans = Math.min(ans, dp[i][k]);
        out.ans(ans).ln();
    }
}
