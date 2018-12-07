package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.mod.Factorial;
import jp.llv.atcoder.lib.math.mod.ModMath;

import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        ModMath m = new ModMath();
        long ans = 1;
        int last = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            if (a < 0) {
                c++;
            } else if (c > 0) {
                ans *= m.nhr(a - last + 1, c);
                ans %= MOD;
                last = a;
                c = 0;
            } else {
                last = a;
            }
        }
        out.println(ans);
     }
}
