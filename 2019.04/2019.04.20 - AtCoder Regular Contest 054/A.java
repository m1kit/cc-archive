package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long l = in.longs(), x = in.longs(), y = in.longs(), s = in.longs(), d = in.longs();
        double ans = (d - s + l) % l / (double) (x + y);
        if (y > x) {
            ans = Math.min(ans, (s - d + l) % l / (double) (y - x));
        }
        out.ans(ans, 10).ln();
    }
}
