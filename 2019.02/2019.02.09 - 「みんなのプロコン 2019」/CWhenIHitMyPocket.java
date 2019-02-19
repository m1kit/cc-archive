package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class CWhenIHitMyPocket {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        long k = in.longs(), a = in.longs(), b = in.longs();
        if (b - a <= 2 || 1 + k < a) {
            out.ans(1 + k).ln();
            return;
        }
        k -= a - 1;
        long ans = a;
        ans += (b - a) * (k / 2);
        if (k % 2 == 1) {
            ans++;
        }
        out.ans(ans).ln();
    }
}
