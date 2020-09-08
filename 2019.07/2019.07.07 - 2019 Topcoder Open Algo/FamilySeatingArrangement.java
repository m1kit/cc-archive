package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class FamilySeatingArrangement {
    private static final int MOD = 1_000_000_007;
    public int countWays(int[] a, int k) {
        ModMath mod = new ModMath();
        int n = a.length;
        Factorial fact = mod.getFactorial(2001);
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            long t = mod.pow(i, n);
            for (int j = i - 1; j >= 1; j--) {
                int c = i - j;
                long v = fact.ncr(i, j);
                v *= mod.pow(j, n);
                v %= MOD;
                if (c % 2 == 1) {
                    t += MOD - v;
                } else {
                    t += v;
                }
                t %= MOD;
            }
            t *= fact.ncr(k, i);
            t %= MOD;
            for (int value : a) {
                t *= mod.pow(1 + k - i, value);
                t %= MOD;
            }
            ans += t;
            ans %= MOD;
        }
        return (int) ans;
    }
}
