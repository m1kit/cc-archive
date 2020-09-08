package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class YC1064 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long b1 = in.longs(), c1 = in.longs(), b2 = in.longs(), c2 = in.longs();
        long b = b1 - b2, c = c1 - c2, det = b * b  - 8 * c;
        if (det < 0) {
            out.noln();
        } else if (det == 0) {
            out.yesln();
        } else {
            double alpha = (Math.sqrt(det) - b) / 4;
            double s = b1 - b * 0.5, t = alpha * alpha + b1 * alpha + c1 - s * alpha;
            out.ans(s, 10).ans(t, 10).ln();
        }
    }
}
