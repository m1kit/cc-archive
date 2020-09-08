package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class EColorfulBlocks {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), k = in.ints();
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(1_000_001);
        long ans = mod.pow(m, n);
        for (int i = k + 1; i < n; i++) {
            ans += MOD - (m * mod.pow(m - 1, n - i - 1) % MOD * fact.ncr(n - 1, i) % MOD);
        }
        out.ans(ans % MOD).ln();
    }
}
