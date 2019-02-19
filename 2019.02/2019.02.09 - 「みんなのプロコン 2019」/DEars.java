package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.geo.Vec2l;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DEars {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);
        long[] sum = new long[n + 1];
        int[] odd = new int[n + 1], even = new int[n + 1];
        int[] zero = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
            zero[i + 1] = zero[i] + (a[i] == 0 ? 1 : 0);
            odd[i + 1] = odd[i];
            even[i + 1] = even[i];
            if (a[i] % 2 == 0) {
                even[i + 1]++;
            } else {
                odd[i + 1]++;
            }
        }

        PriorityQueue<IndexedSegment> rse = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        for (int i = 0; i <= n; i++) {
            rse.add(new IndexedSegment(i, sum[n] - sum[i] + odd[i] + 2 * zero[i]));
        }
        //System.out.println(rse);

        PriorityQueue<IndexedSegment> rss = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        for (int i = 0; i <= n; i++) {
            while (rse.peek().index < i) {
                rse.poll();
            }
            rss.add(new IndexedSegment(i,  rse.peek().cost - odd[i] + even[i] - 2 * zero[i]));
        }
        //System.out.println(rss);

        PriorityQueue<IndexedSegment> lse = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        for (int i = 0; i <= n; i++) {
            while (rss.peek().index < i) {
                rss.poll();
            }
            lse.add(new IndexedSegment(i, rss.peek().cost + odd[i] - even[i] + 2 * zero[i]));
        }
        //System.out.println(lse);

        PriorityQueue<IndexedSegment> lss = new PriorityQueue<>(Comparator.comparing(v -> v.cost));
        for (int i = 0; i <= n; i++) {
            while (lse.peek().index < i) {
                lse.poll();
            }
            lss.add(new IndexedSegment(i, lse.peek().cost - odd[i] + sum[i] - 2 * zero[i]));
        }
        //System.out.println(lss);

        out.ans(lss.peek().cost).ln();
    }

    private static class IndexedSegment {
        public int index;
        public long cost;

        public IndexedSegment(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "{" +
                    "i=" + index +
                    ", cost=" + cost +
                    '}';
        }
    }
}
