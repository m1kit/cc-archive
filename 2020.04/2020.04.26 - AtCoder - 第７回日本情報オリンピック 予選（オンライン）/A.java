package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int[] COINS = {500, 100, 50, 10, 5, 1};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = 1000 - in.ints();
        int ans = 0;
        for (int coin: COINS) {
            ans += n / coin;
            n %= coin;
        }
        out.ans(ans).ln();
    }
}
