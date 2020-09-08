package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AAnotherOneBitesTheDust {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.ints(), b = in.ints(), c = in.ints();
        out.ans(2 * c + Math.min(a, b + 1) + Math.min(b, a + 1)).ln();
    }
}
