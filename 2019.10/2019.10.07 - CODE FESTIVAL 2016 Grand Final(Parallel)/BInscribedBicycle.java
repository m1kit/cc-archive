package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BInscribedBicycle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long[] x = new long[3], y = new long[3];
        in.longs(x, y);
        for (int i = 0; i < 2; i++) {
            x[i] -= x[2];
            y[i] -= y[2];
        }
        x[2] = x[0] - x[1];
        y[2] = y[0] - y[1];

        double s = Math.abs(x[0] * y[1] - x[1] * y[0]) / 2.0;
        double a = Math.sqrt(x[0] * x[0] + y[0] * y[0]);
        double b = Math.sqrt(x[1] * x[1] + y[1] * y[1]);
        double c = Math.sqrt(x[2] * x[2] + y[2] * y[2]);
        double r = (2 * s) / (a + b + c);
        double m = IntMath.max(a, b, c);
        out.ans(m / (2 + m / r), 12).ln();
    }
}
