package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DFretsOnFire {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] s = in.longs(n);
        IntroSort.sort(s);
        int q = in.ints();
        long[] ans = new long[q];
        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            long w = - in.longs() + in.longs() + 1;
            queries[i] = new Query(i, w);
        }
        IntroSort.sort(queries, Comparator.comparing(qry -> qry.width));
        Gap[] gaps = new Gap[n - 1];
        for (int i = 1; i < n; i++) {
            gaps[i - 1] = new Gap(i - 1, i, s[i] - s[i - 1]);
        }
        IntroSort.sort(gaps, Comparator.comparing(gap -> gap.gap));

        long constant = 0;
        int segments = n;
        int gapCur = 0;
        for (int i = 0; i < q; i++) {
            while (gapCur < n - 1 && gaps[gapCur].gap < queries[i].width) {
                constant += gaps[gapCur].gap;
                segments--;
                gapCur++;
            }
            ans[queries[i].index] = segments * queries[i].width + constant;
        }
        out.ansln(ans);
    }

    private static class Query {
        int index;
        long width;

        public Query(int index, long width) {
            this.index = index;
            this.width = width;
        }

        @Override
        public String toString() {
            return "Query{" +
                    "index=" + index +
                    ", width=" + width +
                    '}';
        }
    }

    private static class Gap {
        int prev, next;
        long gap;

        public Gap(int prev, int next, long gap) {
            this.prev = prev;
            this.next = next;
            this.gap = gap;
        }
    }
}
