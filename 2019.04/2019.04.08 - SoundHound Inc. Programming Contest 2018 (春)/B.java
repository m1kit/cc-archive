package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), l = in.ints(), r = in.ints();
        int[] a = in.ints(n);
        for (int i = 0; i < n; i++) {
            out.ans(Math.min(r, Math.max(a[i], l)));
        }
        out.ln();
    }
}
