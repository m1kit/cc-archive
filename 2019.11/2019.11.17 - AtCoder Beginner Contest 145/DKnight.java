package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class DKnight {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int x = in.ints(), y = in.ints();
        if ((x + y) % 3 != 0) {
            out.ans(0).ln();
            return;
        }
        long c = (x + y) / 3;
        x -= c;
        y -= c;
        if (x < 0 || y < 0) {
            out.ans(0).ln();
            return;
        }
        out.ans(new ModMath(MOD).ncr(x + y, x)).ln();
    }
}
