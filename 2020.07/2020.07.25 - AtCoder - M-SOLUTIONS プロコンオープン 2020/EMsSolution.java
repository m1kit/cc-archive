package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class EMsSolution {

    private static final long INF = 1_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] x = new long[n], y = new long[n], p = new long[n];
        in.longs(x, y, p);
        long[][] ansX = solve(n, x, p), ansY = solve(n, y, p);

        long[] ans = new long[n + 1];
        Arrays.fill(ans, INF);

        int all = 1 << n;
        for (int i = 0; i < all; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; j + k <= n; k++) {
                    ans[j + k] = Math.min(ans[j + k], ansX[i][j] + ansY[(all - 1) & ~i][k]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            out.ans(ans[i]).ln();
        }
    }

    private static long[][] solve(int n, long[] x, long[] p) {
        x = Arrays.copyOf(x, n + 1);
        x[n] = 0;
        long[][][] dp = new long[1 << n][n + 1][n + 1];
        ArrayUtil.fill(dp, INF);
        dp[0][n][0] = 0;
        int all = 1 << n;
        for (int i = 0; i < all; i++) {
            for (int j = 0; j < n; j++) { //next
                if ((i & (1 << j)) != 0) continue; // visited already
                int s = i | (1 << j);
                for (int k = 0; k <= n; k++) { // prev built
                    if (k != n && (i & (1 << k)) == 0) continue; // not visited yet
                    for (int m = 0; m < n; m++) {// roads built
                        // use existing
                        dp[s][k][m] = Math.min(dp[s][k][m], dp[i][k][m] + p[j] * Math.abs(x[k] - x[j]));
                        // build new
                        dp[s][j][m + 1] = Math.min(dp[s][j][m + 1], dp[i][k][m]);
                    }
                }
            }
        }

        long[][] ans = new long[all][n + 1];
        for (int i = 0; i < all; i++) {
            for (int j = 0; j <= n; j++) {
                ans[i][j] = INF;
                for (int k = 0; k <= n; k++) {
                    ans[i][j] = Math.min(ans[i][j], dp[i][k][j]);
                }
            }
        }
        return ans;
    }
}
