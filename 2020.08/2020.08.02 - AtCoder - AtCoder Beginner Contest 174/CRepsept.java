package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CRepsept {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long k = in.longs();
        long t = 0;
        for (int i = 0; i < 2_000_000; i++) {
            t = (t * 10 + 7) % k;
            if (t == 0) {
                out.ans(i + 1).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
