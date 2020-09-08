package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = 1, b = 1;
        int k = in.ints();
        for (int i = 1; i < k; i++) {
            int s = a + b;
            a = b;
            b = s;
        }
        out.ans(a).ans(b).ln();
    }
}
