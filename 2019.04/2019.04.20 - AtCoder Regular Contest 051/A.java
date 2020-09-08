package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);

        long x = in.longs(), y = in.longs(), r = in.longs();
        long x0 = in.longs(), y0 = in.longs(), x1 = in.longs(), y1 = in.longs();
        out.ans(x - r < x0 || x1 < x + r || y - r < y0 || y1 < y + r).ln();

        long dx = Math.max(Math.abs(x - x0), Math.abs(x - x1));
        long dy = Math.max(Math.abs(y - y0), Math.abs(y - y1));
        out.ans(dx * dx + dy * dy > r * r).ln();
    }
}
