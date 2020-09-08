package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class DIHateFactorization {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long x = in.longs();
        for (long d : IntMath.getAllDivisors(x)) {
            for (long a = -100000; a <= 100000; a++) {
                long b = a + d;
                long y = pow5(a) - pow5(b);
                if (x == y) {
                    out.ans(a).ans(b).ln();
                    return;
                } else if (x == -y) {
                    out.ans(b).ans(a).ln();
                    return;
                }
            }
        }
    }

    private static long pow5(long x) {
        return x * x * x * x * x;
    }
}
