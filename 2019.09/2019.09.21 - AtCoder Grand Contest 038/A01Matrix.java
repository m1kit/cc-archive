package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A01Matrix {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints(), a = in.ints(), b = in.ints();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out.print((i < b) == (j < a) ? '0' : '1');
            }
            out.ln();
        }
    }
}
