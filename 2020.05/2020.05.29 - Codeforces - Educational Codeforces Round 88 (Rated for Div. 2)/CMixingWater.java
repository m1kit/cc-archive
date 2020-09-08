package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CMixingWater {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long h = in.longs(), c = in.longs(), t = in.longs();
            if (t * 2 <= h + c) {
                out.ans(2).ln();
                continue;
            } else if (t >= h) {
                out.ans(1).ln();
                continue;
            }
            long min = 0, max = 1_000_000_000L;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                if (t * (mid * 2 + 1) >= ((mid + 1) * h + mid * c)) max = mid;
                else min = mid;
            }
            if (((min + 1) * h + min * c) * (max * 2 + 1) + ((max + 1) * h + max * c) * (min * 2 + 1) <= 2 * t * (min * 2 + 1) * (max * 2 + 1)) {
                out.ans(min * 2 + 1).ln();
            } else {
                out.ans(max * 2 + 1).ln();
            }
        }
    }
}
