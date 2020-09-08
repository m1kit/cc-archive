package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BColoredBalls {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long x = in.longs(), y = in.longs();
        if (x < y) {
            long t = x;
            x = y;
            y = t;
        }

        if ((x + y) % 4 > 0) {
            out.noln();
            return;
        }

        long c = x - y;
        if (c % 2 == 1) {
            out.noln();
        }
        c /= 2;
        x -= c * 3;
        y -= c;
        if (x < 0 || y < 0) {
            out.noln();
            return;
        }

        out.ans(x % 4 == 0 && y % 4 == 0).ln();
    }
}
