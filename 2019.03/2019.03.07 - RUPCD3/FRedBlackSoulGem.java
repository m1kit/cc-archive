package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.mod.Exponentiation;
import jp.llv.atcoder.lib.math.mod.Factorial;
import jp.llv.atcoder.lib.math.mod.ModMath;

public class FRedBlackSoulGem {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints();
        ModMath mod = new ModMath(m);
        long ans = 0;
        Exponentiation exp2 = mod.getExponentiation(2, n);
        for (int r = 1; r < n; r++) {
            int b = n - r;

            long t = mod.ncr(n, r);
            t *= mod.pow(2, r * (r - 1L) / 2);
            t %= m;

            t *= mod.pow(2, b * (b - 1L) / 2);
            t %= m;

            long p = 0;
            Factorial fact = mod.getFactorial(b + 1);
            for (int i = 0; i <= b; i++) {
                if (i % 2 == 0) {
                    p += fact.ncr(b, i) * mod.pow(exp2.pow(b - i) - 1, r) % m;
                    p %= m;
                } else {
                    p -= fact.ncr(b, i) * mod.pow(exp2.pow(b - i) - 1, r) % m;
                    p %= m;
                }
            }
            if (p < 0) {
                p += m;
            }

            //System.out.println("r="+r+" b="+b +" p="+p);
            t *= p;
            t %= m;

            ans += t;
            ans %= m;
        }
        out.ans(ans).ln();
    }
}
