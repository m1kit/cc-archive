package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BTouitsu {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        String[] s = in.string(3);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[0].charAt(i) == s[1].charAt(i) && s[1].charAt(i) == s[2].charAt(i)) {

            } else if (s[0].charAt(i) == s[1].charAt(i) || s[1].charAt(i) == s[2].charAt(i) || s[2].charAt(i) == s[0].charAt(i)) {
                ans++;
            } else {
                ans += 2;
            }
        }
        out.ans(ans).ln();
    }
}
