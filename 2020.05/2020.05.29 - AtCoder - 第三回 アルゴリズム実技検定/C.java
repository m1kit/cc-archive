package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), r = in.longs(), n = in.longs();
        if (r == 1) {
            out.ans(a).ln();
            return;
        }
        for (long i = 1; i < n; i++) {
            a *= r;
            if (a > 1_000_000_000L) {
                out.ans("large").ln();
                return;
            }
        }
        out.ans(a).ln();
    }
}
