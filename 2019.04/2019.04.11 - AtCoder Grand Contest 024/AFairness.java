package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFairness {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long[] a = in.longs(3);
        long k = in.longs();
        if (k % 2 == 0) {
            out.ansln(a[0] - a[1]);
        } else {
            out.ansln(a[1] - a[0]);
        }
    }
}
