package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C100To105 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[] x = new int[100200];
        x[0] = 1;
        for (int i = 0; i < 100000; i++) {
            for (int j = 100; j <= 105; j++) {
                x[i + j] |= x[i];
            }
        }
        out.ans(x[in.ints()]).ln();
    }
}
