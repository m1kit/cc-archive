package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;
    private static final double loge2 = Math.log(2);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        double p = in.doubles();
        double d = 3.0 / (2.0 * p * loge2);
        double x = -3.0 / 2.0 * log2(d);
        if (x < 0) {
            out.ans(p, 10).ln();
        } else {
            out.ans(d * p + x, 10).ln();
        }

    }

    private static double log2(double x) {
        return Math.log(x) / loge2;
    }
}
