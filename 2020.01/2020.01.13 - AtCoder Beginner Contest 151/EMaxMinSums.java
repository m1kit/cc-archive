package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class EMaxMinSums {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n);
        IntroSort.sort(a);
        for (int i = 0; i < n; i++) a[i] = (a[i] % MOD + MOD) % MOD;
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n + 1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * fact.ncr(i, k - 1) % MOD;
            ans += (MOD - a[i]) * fact.ncr(n - i - 1, k - 1) % MOD;
            ans %=MOD;
        }
        out.ans(ans).ln();
    }
}
