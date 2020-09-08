package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BFizzBuzzSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        long ans = 0;
        for (long i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) ans += i;
        }
        out.ans(ans).ln();
    }
}
