package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class CUnification {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        String s = in.string();
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                a++;
            } else {
                b++;
            }
        }
        out.ansln(Math.min(a, b) * 2);
    }
}
