package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.math.BigInteger;

public class AFairness {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), b = in.longs(), c = in.longs();
        long k = in.longs();
        if (k % 2 == 1) {
            out.ansln(b - a);
        } else {
            out.ansln(a - b);
        }
    }
}
