package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AWAsedAC {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i - 1] == 'W' && s[i] == 'A') {
                s[i - 1] = 'A';
                s[i] = 'C';
            }
        }
        out.ansln(new String(s));
    }
}
