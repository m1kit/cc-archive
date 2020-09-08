package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.Comparator;
import java.util.Queue;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Road[] roads = new Road[m];
        for (int i = 0; i < m; i++) {
            roads[i] = new Road(in.ints() - 1, in.ints() - 1, in.ints());
        }
        int q = in.ints();
        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            queries[i] = new Query(in.ints() - 1, in.ints());
        }
        Query[] qs = queries.clone();
        IntroSort.sort(roads, Comparator.comparing(r -> -r.t));
        IntroSort.sort(qs, Comparator.comparing(query -> -query.t));
        IntUnionFind uf = new IntUnionFind(n);
        int cur = 0;
        for (Query query : qs) {
            while (cur < m && query.t < roads[cur].t) {
                uf.union(roads[cur].x, roads[cur].y);
                cur++;
            }
            query.ans = uf.size(query.x);
        }
        for (int i = 0; i < q; i++) {
            out.ans(queries[i].ans).ln();
        }
    }

    private static class Road {
        int x, y, t;

        Road(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    private static class Query {
        int x, t, ans;

        Query(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }
}
