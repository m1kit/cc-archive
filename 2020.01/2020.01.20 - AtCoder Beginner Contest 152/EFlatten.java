package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.PrimeTable;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class EFlatten {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long lcm;
        {
            BigInteger _lcm = BigInteger.ONE;
            for (int i = 0; i < n; i++) {
                BigInteger x = BigInteger.valueOf(a[i]);
                _lcm = _lcm.multiply(x).divide(_lcm.gcd(x));
            }
            lcm = _lcm.mod(BigInteger.valueOf(MOD)).longValue();
        }

        long ans = 0;
        ModMath mod = new ModMath(MOD);
        for (int i = 0; i < n; i++) ans += lcm * mod.inv(a[i]) % MOD;
        out.ans(ans % MOD).ln();
    }
}
