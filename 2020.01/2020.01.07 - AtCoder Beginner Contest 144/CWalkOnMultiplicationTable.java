package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CWalkOnMultiplicationTable {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs(), ans = Long.MAX_VALUE;
        for (long x = 1; x <= 1_000_000; x++) {
            if (n % x == 0) ans = Math.min(ans, n / x + x);
        }
        out.ans(ans - 2).ln();
    }
}
