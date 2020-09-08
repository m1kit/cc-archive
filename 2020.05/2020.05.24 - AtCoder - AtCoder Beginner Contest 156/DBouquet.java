package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class DBouquet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), a = in.ints(), b = in.ints();
        ModMath mod = new ModMath();
        out.ans((MOD + MOD + mod.pow(2, n) - mod.ncr(n, a) - mod.ncr(n, b) - 1) % MOD).ln();
    }
}
