package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DRainFlowsIntoDams {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long x0 = a[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) x0 -= a[i];
            else x0 += a[i];
        }
        out.ans(x0);
        for (int i = 0; i < n - 1; i++) {
            out.ans(x0 = a[i] * 2 - x0);
        }
        out.ln();
    }
}
