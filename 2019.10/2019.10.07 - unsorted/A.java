package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.function.IntToLongFunction;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long[] p = in.longs(n);
            IntroSort.sort(p);
            ArrayUtil.reverse(p, 0, n);
            for (int i = 0; i < n; i++) p[i] /= 100;
            Activity[] as = new Activity[]{new Activity(in.ints(), in.ints()), new Activity(in.ints(), in.ints())};
            long common = IntMath.lcm(as[0].per, (long) as[1].per);

            long k = in.longs();
            IntToLongFunction f = d -> {
                long cx = d / common, ca = d / as[0].per - cx, cb = d / as[1].per - cx;
                long total0 = 0, total1 = 0;
                for (int i = 0; i < cx; i++) total0 += p[i] * (as[0].rate + as[1].rate);
                for (int i = 0; i < ca; i++) total0 += p[(int) (cx + i)] * as[0].rate;
                for (int i = 0; i < cb; i++) total0 += p[(int) (cx + ca + i)] * as[1].rate;
                for (int i = 0; i < cx; i++) total1 += p[i] * (as[0].rate + as[1].rate);
                for (int i = 0; i < cb; i++) total1 += p[(int) (cx + i)] * as[1].rate;
                for (int i = 0; i < ca; i++) total1 += p[(int) (cx + cb + i)] * as[0].rate;
                return Math.max(total0, total1);
            };

            if (f.applyAsLong(n) < k) {
                out.ans(-1).ln();
                continue;
            }
            int min = 0, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (f.applyAsLong(mid) < k) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            out.ans(max).ln();
        }
    }

    private static class Activity {
        int rate, per;

        Activity(int rate, int per) {
            this.rate = rate;
            this.per = per;
        }
    }
}
