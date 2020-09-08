package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CBuyAnInteger {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.longs(), b = in.longs(), x = in.longs();
        long min = 0, max = 1_000_000_001;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            if (a * mid + b * d(mid) > x) max = mid;
            else min = mid;
        }
        out.ans(min).ln();
    }

    private static int d(long x) {
        int res = 0;
        while (x > 0) {
            x /= 10;
            res++;
        }
        return res;
    }
}
