package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BEvilator {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        String s = in.string();
        long ans = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == 'D') {
                ans += i;
                ans += 2L * (n - i - 1L);
            } else {
                ans += 2L * i;
                ans += n - i - 1L;
            }
        }
        out.ans(ans).ln();
    }
}
