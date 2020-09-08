package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class No1210XORGrid {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), m = in.ints(), x = in.ints();
        long[] a = in.longs(n), b = in.longs(m);
        long xor = 0;
        for (int i = 0; i < n; i++) xor ^= a[i];
        for (int i = 0; i < m; i++) xor ^= b[i];
        if (xor != 0) {
            out.ans(0).ln();
            return;
        }
        ModMath mod = new ModMath();
        out.ans(mod.pow((1L << x) % MOD, (n - 1L) * (m - 1L))).ln();
    }
}
