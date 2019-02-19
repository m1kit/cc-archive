package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class F {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int p = 1000 - in.ints();
        long v = 1789997546303L;
        for (int i = 0; i < p; i++) {
            if (v % 2 == 0) {
                v = v / 2;
            } else {
                v = 3 * v + 1;
            }
        }
        out.ansln(v);
    }
}
