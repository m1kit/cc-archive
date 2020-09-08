package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), a = in.ints(), b = in.ints();
        int[] c = in.ints(m);
        for (int i = 0; i < m; i++) {
            if (n <= a) {
                n += b;
            }
            if (n < c[i]) {
                out.ans(i + 1).ln();
                return;
            }
            n -= c[i];
        }
        out.ans("complete").ln();
    }
}
