package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class APrimeSubtraction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            out.ans(in.longs() - in.longs() > 1).ln();
        }
    }
}
