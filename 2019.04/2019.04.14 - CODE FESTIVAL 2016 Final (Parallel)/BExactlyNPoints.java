package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BExactlyNPoints {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        long x = 0;
        long p = 1;
        for (; x < n; p++) {
            x += p;
        }
        for (long i = 1; i < p; i++) {
            if (x - n == i) {
                continue;
            }
            out.ansln(i);
        }
    }
}
