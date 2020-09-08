package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class ECellDistance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), k = in.ints();
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n * m + 1);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            long v = i * (long) m * m * (n - i) % MOD;
            v *= fact.ncr(n * m - 2, k - 2);
            ans += v % MOD;
            ans %= MOD;
        }
        for (int i = 1; i < m; i++) {
            long v = i * (long) n * n * (m - i) % MOD;
            v *= fact.ncr(n * m - 2, k - 2);
            ans += v % MOD;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }

}
