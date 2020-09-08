package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Exponentiation;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class CNeitherABNorBA {

    private static final int MOD = 998244353;
    private static final ModMath mod = new ModMath(MOD);
    private static final Factorial fact = mod.getFactorial(10_000_001);
    private static final Exponentiation exp = mod.getExponentiation(2, 10_000_001);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 0;
        for (int a = n / 2 + 1; a <= n; a++) {
            ans += fact.ncr(n, a) * exp.pow(n - a) % MOD;
            ans %= MOD;
        }
        out.ans((mod.pow(3, n) + MOD - ans + MOD - ans) % MOD).ln();
    }
}
