package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.structure.IntMultiSet;
import dev.mikit.atcoder.lib.structure.fenwicktree.AbelianFenwickTree;
import dev.mikit.atcoder.lib.structure.fenwicktree.AbelianIntFenwickTree;
import dev.mikit.atcoder.lib.structure.fenwicktree.IntFenwickTree;

import java.util.Arrays;

public class FRangeSetQuery {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        int[] c = in.ints(n);
        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) queries[i] = new Query(i, in.ints() - 1, in.ints());
        Query[] answers = queries.clone();
        Arrays.sort(queries);
        //System.out.println(Arrays.toString(queries));

        int r = 0;
        int[] last = new int[n + 1];
        Arrays.fill(last, -1);
        AbelianIntFenwickTree bit = new AbelianIntFenwickTree(n, Long::sum, 0L, x -> -x);
        for (Query query : queries) {
            while (r < query.r) {
                if (last[c[r]] != -1) bit.add(last[c[r]], -1);
                last[c[r]] = r;
                bit.add(r, 1);
                r++;
            }
            query.ans = bit.query(query.l, query.r);
        }

        for (Query query : answers) out.ans(query.ans).ln();
    }

    private static class Query implements Comparable<Query> {

        private static final int BLOCK_SIZE = 768;

        final int index;
        final int l, r;
        final int lb, rb;
        long ans;

        Query(int index, int l, int r) {
            this.index = index;
            this.l = l;
            this.r = r;
            this.lb = l / BLOCK_SIZE;
            this.rb = r / BLOCK_SIZE;
        }

        @Override
        public String toString() {
            return "[" + l + ", " + r + ")";
        }

        @Override
        public int compareTo(Query o) {
            //if (this.lb != o.lb) return lb - o.lb;
            if (r != o.r) return r - o.r;
            return l - o.l;
        }
    }


}
