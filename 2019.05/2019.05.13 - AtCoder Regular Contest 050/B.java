package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long r = in.longs(), b = in.longs(), x = in.longs() - 1, y = in.longs() - 1;
        long min = 0, max = Math.min(r, b) + 1;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            long s = r - mid, t = b - mid;
            if ((s / x) + (t / y) >= mid) {
                min = mid;
            } else {
                max = mid;
            }
        }
        out.ans(min).ln();
    }
}
