package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBishop {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long h = in.longs(), w = in.longs();
        if (h ==1 || w==1) out.ans(1).ln();
        else out.ans((h * w + 1) / 2).ln();
    }
}
