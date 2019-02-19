package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class F {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int max = 0;
        int ans = 0;
        int n = in.ints();
        int[] a = in.ints(n);
        for (int i = 0; i < n; i++) {
            if (max < a[i]) {
                ans++;
                max = a[i];
            }
        }
        out.ansln(ans);
    }
}
