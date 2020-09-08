package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AStones {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int t = in.ints();
        for (int i = 0; i < t; i++) {
            int a = in.ints(), b = in.ints(), c = in.ints();
            int k = Math.min(b, c / 2);
            int g = Math.min(a, (b - k) / 2);
            out.ans((k + g) * 3).ln();
        }
    }
}
