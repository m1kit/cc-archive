package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;
import dev.mikit.atcoder.lib.math.linear.MatrixExponentiation;

public class RWalk {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long k = in.longs();
        long[][] a = in.longs(n, n);
        IntMatrix mat = new IntMatrix(n, n, a);
        MatrixExponentiation exp = new MatrixExponentiation(mat, 60, 0, 1, (x, y) -> {
            long s = x + y;
            return s >= MOD ? s - MOD : s;
        }, (x, y) -> x * y % MOD);
        IntMatrix res = exp.power(k);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += res.get(i, j);
            }
        }
        out.ans(ans % MOD).ln();
    }
}
