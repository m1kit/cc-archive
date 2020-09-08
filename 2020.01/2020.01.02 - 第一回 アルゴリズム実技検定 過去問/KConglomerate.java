package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class KConglomerate {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), root = -1;
        int[][] parent = new int[30][n];
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            int p = in.ints() - 1;
            if (p < 0) {
                parent[0][i] = i;
                root = i;
            } else parent[0][i] = p;
        }
        for (int i = 1; i < 30; i++)
            for (int j = 0; j < n; j++)
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
        for (int i = 0; i < n; i++) {
            if (i == root) continue;
            int now = i;
            for (int j = 29; j >= 0; j--) {
                if (parent[j][now] != root) {
                    depth[i] |= 1 << j;
                    now = parent[j][now];
                }
            }
            depth[i]++;
        }

        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            if (depth[a] <= depth[b]) {
                out.noln();
                continue;
            }

            for (int j = 29; j >= 0; j--) {
                if (depth[parent[j][a]] > depth[b]) a = parent[j][a];
            }
            a = parent[0][a];

            out.ans(a == b).ln();
        }
    }
}
