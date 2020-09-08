package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;
import dev.mikit.atcoder.lib.math.linear.IntVector;
import dev.mikit.atcoder.lib.math.linear.MatrixExponentiation;

public class DDessertPlanning {

    private static final int MOD = (int) 1e9 + 7;
    private static final long[][] MAT =
            {
                    {2, 1, 1},
                    {3, 1, 2},
                    {3, 2, 1},
            };

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        IntMatrix mat = new IntMatrix(3, 3, MAT);
        MatrixExponentiation exp = new MatrixExponentiation(mat, 63, 0, (x, y) -> (x + y) % MOD, (x, y) -> x * y % MOD);
        long n = in.longs();
        long[] iv = {1, 0, 0};
        IntVector res = exp.power(n).product(new IntVector(iv));
        long ans = (res.get(0) + res.get(1) + res.get(2)) % MOD;
        out.ans(ans).ln();
    }
}
