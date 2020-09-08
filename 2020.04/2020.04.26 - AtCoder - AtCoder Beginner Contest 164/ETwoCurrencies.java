package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class ETwoCurrencies {

    private static final long INF = 1_000_000_000_000_000L;
    private static final int MAX = 2510;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), s = in.ints();
        int[] u = new int[m], v = new int[m], a = new int[m], b = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = in.ints() - 1;
            v[i] = in.ints() - 1;
            a[i] = in.ints();
            b[i] = in.ints();
        }
        int[] c = new int[n], d = new int[n];
        in.ints(c, d);

        long[][] dp = new long[n][MAX + 1];
        ArrayUtil.fill(dp, INF);
        dp[0][Math.min(s, MAX)] = 0;
        for (int j = 0; j <= MAX; j++)
            dp[0][Math.min(MAX, j + c[0])] = Math.min(dp[0][Math.min(MAX, j + c[0])], dp[0][j] + d[0]);
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int i = 0; i < m; i++) {
                for (int j = a[i]; j <= MAX; j++) {
                    if (dp[v[i]][j] + b[i] < dp[u[i]][j - a[i]]) {
                        dp[u[i]][j - a[i]] = dp[v[i]][j] + b[i];
                        updated = true;
                    }
                    if (dp[u[i]][j] + b[i] < dp[v[i]][j - a[i]]) {
                        dp[v[i]][j - a[i]] = dp[u[i]][j] + b[i];
                        updated = true;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= MAX; j++) {
                    int dest = Math.min(MAX, j + c[i]);
                    if (dp[i][j] + d[i] < dp[i][dest]) {
                        updated = true;
                        dp[i][dest] = dp[i][j] + d[i];
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            long ans = INF;
            for (int j = 0; j <= MAX; j++) ans = Math.min(ans, dp[i][j]);
            out.ans(ans).ln();
        }
    }
}
