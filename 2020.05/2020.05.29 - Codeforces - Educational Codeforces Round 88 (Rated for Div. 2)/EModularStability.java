package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class EModularStability {

    private static final int MOD = 998244353 ;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(Math.max(n, k) + 1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += fact.ncr(n / i - 1, k - 1);
        }
        out.ans(ans % MOD).ln();
    }
}
