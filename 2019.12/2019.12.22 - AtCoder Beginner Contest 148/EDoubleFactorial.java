package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EDoubleFactorial {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        if (n % 2 != 0) {
            out.ans(0).ln();
            return;
        }
        long ans = 0;
        while (n >= 5) {
            n /= 5;
            ans += n / 2;
        }
        out.ans(ans).ln();
    }
}
