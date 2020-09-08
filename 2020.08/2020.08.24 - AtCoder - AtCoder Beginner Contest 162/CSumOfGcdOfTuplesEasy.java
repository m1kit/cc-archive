package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CSumOfGcdOfTuplesEasy {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints();
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= k; l++) {
                    ans += IntMath.gcd(i, j, l);
                }
            }
        }
        out.ans(ans).ln();
    }
}
