package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ADigitsSum {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        if (Integer.toString(n).matches("^10+$")) {
            out.ansln(10);
            return;
        }
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
        }
        out.ansln(ans);
    }
}
