package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFiveVariables {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        for (int i = 0; i < 5; i++) {
            if (in.ints() == 0) {
                out.ans(i + 1).ln();
                return;
            }
        }
    }
}
