package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LGradation {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] x = new int[n + m], y = new int[n + m], c = new int[n + m];
        for (int i = 0; i < n + m; i++) {
            x[i] = in.ints();
            y[i] = in.ints();
            c[i] = in.ints();
        }
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < (1 << m); i++) {
            List<Edge> edges = new ArrayList<>();
            IntUnionFind uf = new IntUnionFind(n + m);
            for (int j = 0; j < n + m; j++) {
                if (j >= n && ((1 << (j - n)) & i) == 0) continue;
                for (int k = 0; k < j; k++) {
                    if (k >= n && ((1 << (k - n)) & i) == 0) continue;
                    double dx = Math.abs(x[j] - x[k]), dy = Math.abs(y[j] - y[k]);
                    Edge edge = new Edge(k, j, Math.sqrt(dx * dx + dy * dy));
                    if (c[j] != c[k]) edge.cost *= 10.0;
                    edges.add(edge);
                }
            }
            double res = 0;
            edges.sort(Comparator.comparing(edge -> edge.cost));
            for (Edge edge : edges) {
                if (uf.union(edge.x, edge.y)) res += edge.cost;
            }
            ans = Math.min(ans, res);
        }
        out.ans(ans, 12).ln();
    }

    private static class Edge {
        int x, y;
        double cost;

        public Edge(int x, int y, double cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
