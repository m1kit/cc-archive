package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class EAnotherFillingTheGrid {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n + 1);
        long k = in.longs();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                long v = mod.pow(k, (n - i) * (n - j));
                v *= fact.ncr(n, i) * fact.ncr(n, j) % MOD;
                v %= MOD;
                v *= mod.pow(k - 1, n * n - (n - i) * (n - j));
                v %= MOD;
                if ((i + j) % 2 == 0) ans += v;
                else ans += MOD - v;
                ans %= MOD;
            }
        }
        out.ans(ans).ln();
    }
}
