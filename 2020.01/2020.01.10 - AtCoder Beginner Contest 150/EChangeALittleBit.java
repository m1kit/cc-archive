package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class EChangeALittleBit {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n + 1);
        long[] c = in.longs(n);


        IntroSort.sort(c);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int right = n - i - 1;
            ans += mod.pow(2, n - 2) * c[i] % MOD * (right + 2) % MOD;
            ans %= MOD;
        }
        out.ans(ans * mod.pow(2, n) % MOD).ln();
    }
}
