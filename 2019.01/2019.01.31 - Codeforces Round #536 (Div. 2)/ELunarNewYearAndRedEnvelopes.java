package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ELunarNewYearAndRedEnvelopes {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints(), k = in.ints();

        Seg[] segments = new Seg[k];
        PriorityQueue<Seg> add = new PriorityQueue<>(Comparator.comparing(seg -> -seg.end));
        Comparator<Seg> bobPref = Comparator.comparing(seg -> -seg.w);
        PriorityQueue<Seg> avlb = new PriorityQueue<>(bobPref.thenComparing(seg -> -seg.res));
        for (int i = 0; i < k; i++) {
            segments[i] = new Seg(in.ints() - 1, in.ints() - 1, in.ints() /* -1 */, in.longs());
            add.add(segments[i]);
        }

        long[][] min = new long[m + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            while (!add.isEmpty() && i <= add.peek().end) {
                avlb.add(add.poll());
            }
            while (!avlb.isEmpty() && i < avlb.peek().start) {
                avlb.poll();
            }
            if (avlb.isEmpty()) {
                for (int j = 0; j <= m; j++) {
                    min[j][i] = min[j][i + 1];
                }
            } else {
                Seg seg = avlb.peek();
                for (int j = 0; j <= m; j++) {
                    long res;
                    if (seg.res >= n) {
                        res = seg.w;
                    } else {
                        res = min[j][seg.res] + seg.w;
                    }
                    min[j][i] = res;
                }
                // 使う場合の遷移
                for (int j = 1; j <= m; j++) {
                    min[j][i] = Math.min(min[j][i], min[j - 1][i + 1]);
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.min(ans, min[i][0]);
        }
        out.ans(ans).ln();
    }

    private static class Seg /*implements Comparable<Seg>*/ {
        int start;
        int end;
        int res;
        long w;

        public Seg(int s, int t, int d, long w) {
            this.start = s;
            this.end = t;
            this.res = d;
            this.w = w;
        }
    }
}
