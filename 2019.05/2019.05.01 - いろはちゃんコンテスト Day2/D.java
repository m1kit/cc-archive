package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(i,in.ints() - 1, in.ints() - 1, in.ints());
        }
        Arrays.sort(edges, Comparator.comparing(e -> -e.cost));
        boolean[] used = new boolean[m];
        for (int i = 0; i < m; i++) {
            Edge e = edges[i];
            if (uf.union(e.from, e.to)) {
                used[e.index] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (used[i]) {
                out.ans(i + 1).ln();
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int index, from, to, cost;

        public Edge(int index, int from, int to, int cost) {
            this.index = index;
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.cost, cost);
        }
    }
}
