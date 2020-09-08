package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class NLandClearing {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long w = in.longs(), c = in.longs();
        Set<Long> cands = new HashSet<>();
        cands.add(0L);

        Interval[] left = new Interval[n];
        for (int i = 0; i < n; i++) {
            left[i] = new Interval(in.longs(), in.longs(), in.longs());
            if (left[i].r + c <= w) cands.add(left[i].r);
        }
        Arrays.sort(left, Comparator.comparing(interval -> interval.l));
        Interval[] right = left.clone();
        Arrays.sort(right, Comparator.comparing(interval -> interval.r));

        long[] sumL = new long[n + 1], sumR = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sumL[i + 1] = sumL[i] + left[i].c;
            sumR[i + 1] = sumR[i] + right[i].c;
        }

        long ans = Long.MAX_VALUE;
        for (long cand : cands) {
            long t = sumL[ArrayUtil.minTrue(left, interval -> interval.l >= cand + c)]
                    - sumR[ArrayUtil.minTrue(right, interval -> interval.r > cand)];
            ans = Math.min(ans, t);
        }
        out.ans(ans).ln();
    }

    private static class Interval {
        long l, r, c;

        public Interval(long l, long r, long c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
}
