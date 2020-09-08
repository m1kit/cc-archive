package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class Task {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(n);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += in.longs() * fact.ncr(n - 1, i) % MOD;
        out.ans(ans % MOD).ln();
    }
}
