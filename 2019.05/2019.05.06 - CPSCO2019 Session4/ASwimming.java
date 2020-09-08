package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ASwimming {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int l = in.ints(), x = in.ints();
        x %= 2 * l;
        if (x < l) {
            out.ans(x).ln();
        } else {
            out.ans(2 * l - x).ln();
        }
    }
}
