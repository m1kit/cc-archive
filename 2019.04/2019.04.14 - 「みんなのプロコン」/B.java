package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long x = in.longs() + 1, k = in.longs();
        long m = 1;
        for (int i = 0; i < k; i++) {
            m *= 10;
        }
        out.ansln((x + m - 1) / m * m);
    }
}
