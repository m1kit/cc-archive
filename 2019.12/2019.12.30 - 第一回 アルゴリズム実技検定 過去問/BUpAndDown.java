package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BUpAndDown {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long x = in.longs();
        for (int i = 1; i < n; i++) {
            long y = in.longs();
            if (x == y) {
                out.ans("stay").ln();
            } else if (x < y) {
                out.ans("up").ans(y - x).ln();
            } else {
                out.ans("down").ans(x - y).ln();
            }
            x = y;
        }
    }
}
