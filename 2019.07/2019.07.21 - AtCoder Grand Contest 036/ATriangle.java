package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATriangle {

    private static final int BASE = (int) 1e9;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long s = in.longs();
        out.ans(0).ans(0);
        long large = (s + BASE - 1) / BASE;
        out.ans(large).ans(1).ans(large * BASE - s).ans(BASE).ln();
    }
}
