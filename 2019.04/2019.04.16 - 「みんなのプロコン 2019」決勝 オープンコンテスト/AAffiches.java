package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AAffiches {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long h = in.longs(), w = in.longs(), a = in.longs(), b = in.longs();
        out.ans(getExpectedLength(h, a) * getExpectedLength(w, b), 12).ln();
    }

    private static double getExpectedLength(long h, long a) {
        if (h >= 2 * a) {
            double eh = Math.pow(a, 3) * 5 / 3 + Math.pow(a, 2) * (h - 3.0 * a);
            eh /= Math.pow(h - a, 2);
            return eh;
        } else {
            return 1.0 / 3 * (4.0 * a - h);
        }
    }
}
