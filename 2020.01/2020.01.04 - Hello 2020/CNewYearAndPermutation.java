package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class CNewYearAndPermutation {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        long ans = 0;
        ModMath mod = new ModMath(m);
        Factorial fact = mod.getFactorial(n + 1);
        for (int i = 1; i <= n; i++) {
            long t = fact.fact(i) * fact.fact(n - i) % m;
            t *= (n - i + 1);
            t %= m;
            t *= (n - i + 1);
            t %= m;
            ans += t;
            ans %= m;
        }
        out.ans(ans).ln();
    }
}
