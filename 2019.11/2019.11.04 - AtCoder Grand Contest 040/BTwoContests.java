package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class BTwoContests {

    private static final int MOD = (int) 1e9 + 7;
    private static final Comparator<Seg> R_INC = Comparator.comparing(seg -> seg.r);
    private static final Comparator<Seg> R_DEC = Comparator.comparing(seg -> -seg.r);
    private static final Comparator<Seg> L_INC = Comparator.comparing(seg -> seg.l);
    private static final Comparator<Seg> L_DEC = Comparator.comparing(seg -> -seg.l);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Seg[] segs = new Seg[n];
        for (int i = 0; i < n; i++) segs[i] = new Seg(in.longs(), in.longs());

        long ans = 0;

        pattern1:
        {
            IntroSort.sort(segs, R_INC.thenComparing(L_INC));
            long[] maxL = new long[n + 1], minR = new long[n + 1];
            minR[n] = Long.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                maxL[i] = Math.max(maxL[i + 1], segs[i].l);
                minR[i] = Math.min(minR[i + 1], segs[i].r);
            }

            long left = 0, right = segs[0].r;
            for (int i = 0; i < n - 1; i++) {
                left = Math.max(left, segs[i].l);
                right = Math.min(right, segs[i].r);
                ans = Math.max(ans, Math.max(right - left + 1, 0) + Math.max(minR[i + 1] - maxL[i + 1] + 1, 0));
            }
        }

        pattern2:
        {
            IntroSort.sort(segs, L_DEC.thenComparing(R_DEC));
            long[] maxL = new long[n + 1], minR = new long[n + 1];
            minR[n] = Long.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                maxL[i] = Math.max(maxL[i + 1], segs[i].l);
                minR[i] = Math.min(minR[i + 1], segs[i].r);
            }

            long left = 0, right = segs[0].r;
            for (int i = 0; i < n - 1; i++) {
                left = Math.max(left, segs[i].l);
                right = Math.min(right, segs[i].r);
                ans = Math.max(ans, Math.max(right - left + 1, 0) + Math.max(minR[i + 1] - maxL[i + 1] + 1, 0));
            }
        }

        pattern3:
        {
            long[] maxLLeft = new long[n + 1], minRLeft = new long[n + 1];
            long[] maxLRight = new long[n + 1], minRRight = new long[n + 1];
            minRLeft[0] = minRRight[n] = Long.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                maxLRight[i] = Math.max(maxLRight[i + 1], segs[i].l);
                minRRight[i] = Math.min(minRRight[i + 1], segs[i].r);
            }
            for (int i = 0; i < n; i++) {
                maxLLeft[i + 1] = Math.max(maxLLeft[i], segs[i].l);
                minRLeft[i + 1] = Math.min(minRLeft[i], segs[i].r);
            }
            //System.out.println(Arrays.toString(segs));
            for (int i = 0; i < n; i++) {
                long v = segs[i].width() + Math.max(0, 1 + Math.min(minRLeft[i], minRRight[i + 1]) - Math.max(maxLLeft[i], maxLRight[i + 1]));
                //System.out.println("i=" + i + " v=" + v + "(l=" + Math.max(maxLLeft[i], maxLRight[i + 1]) + ", r=" + Math.max(0, Math.min(minRLeft[i], minRRight[i + 1])) + ")");
                ans = Math.max(ans, v);
            }
        }

        out.ans(ans).ln();
    }

    private static class Seg {
        long l, r;

        Seg(long l, long r) {
            this.l = l;
            this.r = r;
        }

        long width() {
            return r - l + 1;
        }

        @Override
        public String toString() {
            return "(" + l + ", " + r + ")";
        }
    }
}
