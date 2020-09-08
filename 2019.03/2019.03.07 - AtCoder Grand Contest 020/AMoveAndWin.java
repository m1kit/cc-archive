package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AMoveAndWin {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), a = in.ints(), b = in.ints();
        if ((b - a) % 2 == 1) {
            out.ansln("Borys");
        } else {
            out.ansln("Alice");
        }
    }
}
