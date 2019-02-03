package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ADigitsSequenceDividing {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int query = in.ints();
        for (int q = 0; q < query; q++) {
            int n = in.ints();
            String s = in.string();
            if (n == 2) {
                if (s.charAt(0) < s.charAt(1)) {
                    out.ans(YES).ln().ans(2).ln().ans(s.charAt(0)).ans(s.charAt(1)).ln();
                } else {
                    out.ans(NO).ln();
                }
            } else {
                out.ans(YES).ln().ans(2).ln().ans(s.charAt(0)).ans(s.substring(1)).ln();
            }
        }
    }
}
