package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class APrefixAndSuffix {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        String s = in.string(), t = in.string();
        outer: for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(j) != t.charAt(j - i)) {
                    continue outer;
                }
            }
            out.ansln(n + i);
            return;
        }
        out.ansln(2 * n);
    }
}
