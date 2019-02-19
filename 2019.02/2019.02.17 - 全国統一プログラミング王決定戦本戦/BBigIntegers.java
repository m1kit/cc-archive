package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BBigIntegers {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int  n= in.ints(), m = in.ints();
        long k = in.longs();
        long[] a = in.longs(n), b = in.longs(m);

        if (n < m) {
            out.ansln("X");
            return;
        } else if (n > m) {
            out.ansln("Y");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                out.ansln("X");
                return;
            } else if (a[i] > b[i]) {
                out.ansln("Y");
                return;
            }
        }
        out.ansln("Same");
    }
}
