package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ASplittingIntoDigits {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        Debug.autoEnable();
        int n = in.ints();
        out.ans(n).ln();
        for (int i = 0; i < n; i++) {
            out.ans(1);
        }
        out.ln();
    }
}
