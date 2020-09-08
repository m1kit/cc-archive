package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BCountBalls {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs(), a = in.longs(), b = in.longs();
        out.ans(n / (a + b) * a + Math.min(n % (a + b), a)).ln();
    }
}
