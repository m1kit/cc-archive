package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AHarmony {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long d = Math.abs(in.longs() + in.longs());
        if (d % 2 == 1) {
            out.ans("IMPOSSIBLE").ln();
            return;
        }
        out.ans(d / 2).ln();
    }
}
