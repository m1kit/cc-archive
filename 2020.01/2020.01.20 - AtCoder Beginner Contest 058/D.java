package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        long[] x = in.longs(n), y = in.longs(m);
        long a = 0, b = 0;
        ModMath mod = new ModMath(MOD);
        for (int i = 1; i < n; i++) {
            a += (x[i] - x[i - 1]) * i % MOD * (n - i) % MOD;
            a %= MOD;
        }
        for (int i = 1; i < m; i++) {
            b += (y[i] - y[i - 1]) * i % MOD * (m - i) % MOD;
            b %= MOD;
        }
        out.ans(a * b % MOD).ln();
    }
}
