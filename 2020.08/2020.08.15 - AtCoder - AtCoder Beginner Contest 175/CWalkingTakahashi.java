package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CWalkingTakahashi {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long x = in.longs(), k = in.longs(), d = in.longs();
        x = Math.abs(x);
        long c = Math.min(k, x / d);
        x -= d * c;
        k -= c;
        if (k % 2 == 1) x -= d;
        out.ans(Math.abs(x)).ln();
    }
}
