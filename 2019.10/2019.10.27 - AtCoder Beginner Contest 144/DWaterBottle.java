package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DWaterBottle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        double a = in.doubles(), b = in.doubles(), x = in.doubles() / a;
        if (2 * x >= a * b) {
            out.ans(Math.atan2((a * b - x) * 2 / a, a) / Math.PI * 180, 10).ln();
        } else {
            out.ans(Math.atan2(b, 2 * x / b) / Math.PI * 180, 10).ln();
        }
    }
}
