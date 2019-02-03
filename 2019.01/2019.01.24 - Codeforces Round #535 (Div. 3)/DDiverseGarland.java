package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class DDiverseGarland {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static char[] COLS = {'R', 'G', 'B'};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        String s = in.string();
        int ans = 0;
        char last = ' ';
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == last) {
                int t = 0;
                if (COLS[t] == last) {
                    t++;
                }
                if (i < n - 1 && s.charAt(i + 1) == COLS[t]) {
                    t++;
                }
                if (COLS[t] == last) {
                    t++;
                }
                last = COLS[t];
                ans++;
                res.append(last);
            } else {
                last = s.charAt(i);
                res.append(s.charAt(i));
            }
        }
        out.ans(ans).ln().ans(res).ln();
    }
}
