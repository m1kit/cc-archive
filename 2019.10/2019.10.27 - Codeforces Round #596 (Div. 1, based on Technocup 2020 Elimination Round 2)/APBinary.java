package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

public class APBinary {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs(), p = in.longs();
        for (int i = 1; i <= 60; i++) {
            if (n > p * i && i >= BitMath.count(n - p * i) && n - p * i >= i) {
                out.ans(i).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
