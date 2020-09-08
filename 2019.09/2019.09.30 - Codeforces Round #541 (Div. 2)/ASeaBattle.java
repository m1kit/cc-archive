package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ASeaBattle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), c = in.ints(), d = in.ints();
        int w = a, h = b + d;
        out.ans((w + 2L) * (h + 2L) - w * (long) h).ln();
    }
}
