package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs(), a = in.longs(), b = in.longs(), ans = Long.MAX_VALUE;
        if ((b - a) % 2 == 0) {
            ans = (b - a) / 2;
        } else {
            ans = Math.min(ans, (a + b - 1) / 2);
            ans = Math.min(ans, (2 * n - a - b + 1) / 2);
        }
        out.ans(ans).ln();
    }
}
