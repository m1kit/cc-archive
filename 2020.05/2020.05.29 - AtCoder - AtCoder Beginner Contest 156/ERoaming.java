package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class ERoaming {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = Math.min(n - 1, in.ints());
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(2 * n);
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans += fact.ncr(n, i) * fact.nhr(n - i, i) % MOD;
        }
        out.ans(ans % MOD).ln();
    }
}
