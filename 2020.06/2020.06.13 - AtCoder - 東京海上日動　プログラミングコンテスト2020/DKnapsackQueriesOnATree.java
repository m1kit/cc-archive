package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.fenwicktree.IntFenwickTree;

import java.util.ArrayList;
import java.util.List;

public class DKnapsackQueriesOnATree {

    private static final int DMAX = 11;
    private static final int DMAX2 = (1 << DMAX) - 1;
    private static final int MAX = 100002;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[][] dp = new int[DMAX2][MAX];
        int[] vs = new int[n], ws = new int[n];
        for (int i = 0; i < n; i++) {
            vs[i] = in.ints();
            ws[i] = in.ints();
        }

        int n0 = Math.min(DMAX2, n);
        for (int i = ws[0]; i < MAX; i++) dp[0][i] = vs[0];
        for (int k = 1; k < n0; k++) {
            int parent = (k - 1) / 2;
            System.arraycopy(dp[parent], 0, dp[k], 0, ws[k]);
            for (int i = ws[k]; i < MAX; i++) {
                dp[k][i] = Math.max(dp[parent][i], dp[parent][i - ws[k]] + vs[k]);
            }
        }

        int queries = in.ints();
        for (int i = 0; i < queries; i++) {
            int node = in.ints() - 1, l = in.ints();
            if (node < n0) {
                out.ans(dp[node][l]).ln();
                continue;
            }
            int m = 0;
            int cur = node;
            while (cur >= n0) {
                cur = (cur - 1) / 2;
                m++;
            }
            long ans = 0;
            outer:
            for (int j = 0; j < (1 << m); j++) {
                int w = 0, v = 0, t = j, now = node;
                for (int k = 0; k < m; k++) {
                    if ((t & 1) == 1) {
                        w += ws[now];
                        v += vs[now];
                        if (w > l) continue outer;
                    }
                    t >>= 1;
                    now = (now - 1) >> 1;
                }
                ans = Math.max(ans, dp[cur][l - w] + v);
            }
            out.ans(ans).ln();
        }
    }
}
