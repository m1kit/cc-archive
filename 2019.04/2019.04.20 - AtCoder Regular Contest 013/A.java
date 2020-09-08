package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), l = in.ints();
        int p = in.ints(), q = in.ints(), r = in.ints();
        out.ans(IntMath.max(
                calc(n, m, l, p, q, r),
                calc(n, m, l, p, r, q),
                calc(n, m, l, q, p, r),
                calc(n, m, l, q, r, p),
                calc(n, m, l, r, p, q),
                calc(n, m, l, r, q, p)
        )).ln();
    }

    private static int calc(int n, int m, int l, int p, int q, int r) {
        return (n / p) * (m / q) * (l / r);
    }
}
