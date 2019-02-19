package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.math.euclid.BigIntEuclidSolver;
import jp.llv.atcoder.lib.math.euclid.LongEuclidSolver;
import jp.llv.atcoder.lib.geo.Vec2b;
import jp.llv.atcoder.lib.geo.Vec3l;
import jp.llv.atcoder.lib.math.linear.Matrix;
import jp.llv.atcoder.lib.math.linear.MatrixExponentiation;
import jp.llv.atcoder.lib.math.linear.Vector;
import jp.llv.atcoder.lib.math.mod.ModMath;

import java.math.BigInteger;

public class FLunarNewYearAndARecursiveSequence {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();

        int k = in.ints();
        long[] b = in.longs(k);

        Vector iv = new Vector(k);
        for (int i = 0; i < k - 1; i++) {
            iv.set(i, 1);
        }

        int n = in.ints();
        long m = in.longs();

        Matrix mat = new Matrix(k, k);
        for (int i = 0; i < k; i++) mat.set(0, i, b[i]);
        for (int i = 1; i < k; i++) mat.set(i, i - 1, 1);

        ModMath mod1 = new ModMath(MOD - 1), mod2 = new ModMath(MOD);
        MatrixExponentiation exp = new MatrixExponentiation(
                mat, 30, 0,  mod1::add, mod1::prod
        );



        Matrix res = exp.power(n - k);


        long t = res.get(0, 0);
        long s = mod2.log(3, m);
        long d = IntMath.gcd(t, MOD - 1);
        if (s % d != 0) {
            out.ans(-1).ln();
            return;
        }
        long x = mod2.log(mod2.pow(3, t), m);
        out.ans(mod2.pow(3, x)).ln();

    }
}
