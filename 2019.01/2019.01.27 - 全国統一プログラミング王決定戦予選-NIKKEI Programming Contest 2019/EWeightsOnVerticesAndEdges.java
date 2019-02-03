package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.UnionFind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.IntStream;

public class EWeightsOnVerticesAndEdges {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        long[] x = in.longs(n);
        Edge[] e = new Edge[m];
        for (int i = 0; i < m; i++) {
            e[i] = new Edge(in.ints() - 1, in.ints() - 1, in.longs());
        }
        Arrays.sort(e, Comparator.comparing(edge -> edge.w));
        UnionFind uf = new UnionFind(n);
        long[] size = x.clone();
        int[] pending = new int[n];
        int[] commit = new int[n];
        long ans = 0;
        for (int i = 0; i < m; i++) {
            Edge edge = e[i];
            if (uf.find(edge.a) == uf.find(edge.b)) {
                int gr = uf.find(edge.a);
                long s = size[gr];
                int p = pending[gr] + 1;
                pending[gr]++;
                if (s >= edge.w) {
                    commit[gr] = pending[gr];
                }
            } else {
                int gr1 = uf.find(edge.a), gr2 = uf.find(edge.b);
                long s = size[gr1] + size[gr2];
                int p = pending[gr1] + pending[gr2] + 1;
                int c = commit[gr1] + commit[gr2];
                size[gr1] = 0;
                size[gr2] = 0;
                pending[gr1] = 0;
                pending[gr2] = 0;
                uf.union(edge.a, edge.b);
                int gr = uf.find(edge.a);
                size[gr] = s;
                pending[gr] = p;

                commit[gr1] = 0;
                commit[gr2] = 0;
                commit[gr] = c;
                if (s >= edge.w) {
                    commit[gr] = p;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans += commit[i];
        }
        //System.out.println(Arrays.toString(commit));
        out.ans(m - ans).ln();
    }

    private static class Edge {
        int a, b;
        long w;

        public Edge(int a, int b, long w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return a == edge.a &&
                    b == edge.b &&
                    w == edge.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, w);
        }
    }
}
