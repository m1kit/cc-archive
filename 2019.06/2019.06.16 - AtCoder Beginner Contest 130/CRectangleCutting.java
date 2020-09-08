package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CRectangleCutting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long w = in.longs(), h = in.longs(), x = in.longs(), y = in.longs();
        out.ans(w * h * 0.5, 6).ans(2 * x == w && 2 * y == h ? 1 : 0).ln();
    }
}
