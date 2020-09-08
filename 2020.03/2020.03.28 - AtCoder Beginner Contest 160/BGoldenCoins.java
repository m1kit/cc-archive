package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BGoldenCoins {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long x = in.longs(), ans = 0;
        ans += x / 500 * 1000;
        x %= 500;
        ans += x / 5 * 5;
        out.ans(ans).ln();
    }
}
