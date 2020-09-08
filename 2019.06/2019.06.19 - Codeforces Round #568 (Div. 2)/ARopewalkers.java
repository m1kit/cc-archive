package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class ARopewalkers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long[] x = in.longs(3);
        long d = in.longs();
        IntroSort.sort(x);
        out.ans(Math.max(d - (x[1] - x[0]), 0) + Math.max(d - (x[2] - x[1]), 0)).ln();
    }
}
