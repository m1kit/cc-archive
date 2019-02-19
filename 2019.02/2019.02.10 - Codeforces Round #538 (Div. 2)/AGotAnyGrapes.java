package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AGotAnyGrapes {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");

        int x = in.ints(), y = in.ints(), z = in.ints();
        int a = in.ints(), b = in.ints(), c = in.ints();

        if (x > a) {
            out.ans(NO).ln();
            return;
        }
        a -= x;

        int d = a + b;
        if (y > d) {
            out.ans(NO).ln();
            return;
        }
        d -= y;

        int e = d + c;
        if (z > e) {
            out.ans(NO).ln();
            return;
        }
        out.ans(YES).ln();
    }
}
