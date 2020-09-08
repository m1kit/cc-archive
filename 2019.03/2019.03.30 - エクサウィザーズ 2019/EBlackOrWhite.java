package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Exponentiation;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class EBlackOrWhite {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int b = in.ints(), w = in.ints();
        ModMath mod = new ModMath();
        Exponentiation exp = mod.getExponentiation(2, b + w + 1);
        Factorial fact = mod.getFactorial(b + w + 1);

        long p = 0, q = 0;
        for (int i = 1; i <= b + w; i++) {
            out.ansln((1 - p + q + MOD) % MOD * exp.pow(-1) % MOD);
            p += fact.ncr(i - 1, b - 1) * exp.pow(-i) % MOD;
            p %= MOD;
            q += fact.ncr(i - 1, w - 1) * exp.pow(-i) % MOD;
            q %= MOD;
        }
    }
}
