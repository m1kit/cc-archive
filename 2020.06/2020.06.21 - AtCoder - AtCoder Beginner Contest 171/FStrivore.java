package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Exponentiation;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class FStrivore {

    private static final int MOD = (int) 1e9 + 7;
    private static final int MAX = 2_000_010;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints();
        int n = in.string().length();
        long ans = 0;
        ModMath mod = new ModMath();
        Exponentiation pow25 = mod.getExponentiation(25, MAX);
        Exponentiation pow26 = mod.getExponentiation(26, MAX);
        Factorial fact = mod.getFactorial(MAX);
        for (int j = 0; j <= k; j++) {
            long d = pow26.pow(j);
            d %= MOD;
            d *= pow25.pow(k - j);
            d %= MOD;
            d *= fact.nhr(n, k - j);
            d %= MOD;
            ans += d;
        }
        out.ans(ans % MOD).ln();
    }
}
