package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class CGridGame {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        String s = in.string();
        int c0 = 0, c1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                out.ans(1).ans(c0 + 1).ln();
                c0++;
                c0 %= 4;
            } else {
                out.ans(3).ans(c1 * 2 + 1).ln();
                c1++;
                c1 %= 2;
            }
        }
    }
}
