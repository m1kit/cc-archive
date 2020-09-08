package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;

public class AEatingSoup {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        if (n == m) {
            out.ans(0).ln();
        } else if (m <= 1) {
            out.ans(1).ln();
        } else if (n <= m * 2) {
            out.ans(n - m).ln();
        } else {
            out.ans(m).ln();
        }
    }
}
