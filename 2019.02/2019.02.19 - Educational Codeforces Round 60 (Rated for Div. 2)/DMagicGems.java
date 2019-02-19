package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.linear.Matrix;
import jp.llv.atcoder.lib.math.linear.MatrixExponentiation;
import jp.llv.atcoder.lib.math.linear.Vector;
import jp.llv.atcoder.lib.math.mod.ModMath;

public class DMagicGems {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        int m = in.ints();

        Matrix mat = new Matrix(m, m);
        mat.set(0, 0, 1);
        mat.set(0, m - 1, 1);
        for (int i = 1; i < m; i++) {
            mat.set(i, i - 1, 1);
        }
        MatrixExponentiation exp = new MatrixExponentiation(mat, 60, 0, (x, y) -> (x + y) % MOD, (x, y) -> (x * y) % MOD);

        Vector a = new Vector(m);
        for (int i = 0; i < m; i++) {
            a.set(i, 1);
        }
        out.ansln(exp.power(n).product(a, 0, (x, y) -> (x + y) % MOD, (x, y) -> (x * y) % MOD).get(m - 1));
    }
}
