package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(m);
        boolean[] f = new boolean[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            if (f[a[i]]) continue;
            f[a[i]] = true;
            out.ans(a[i]).ln();
        }
        for (int i = 1; i <= n; i++) {
            if (f[i]) continue;
            out.ans(i).ln();
        }
    }
}
