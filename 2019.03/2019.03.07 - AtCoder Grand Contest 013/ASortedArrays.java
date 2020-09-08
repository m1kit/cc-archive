package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ASortedArrays {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);

        int d = 0;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) {
                continue;
            } else if (a[i - 1] < a[i]) {
                if (d >= 0) {
                    d = 1;
                } else {
                    ans++;
                    d = 0;
                }
            } else {
                if (d <= 0) {
                    d = -1;
                } else {
                    ans++;
                    d = 0;
                }
            }
        }
        out.ansln(ans);
    }
}
