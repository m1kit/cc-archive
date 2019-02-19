package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class IN {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        int[] a = in.ints(n);
        int j = 0;
        long sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sum < n) {
                sum += a[j++];
            }
            if (sum == n) {
                ans++;
            }
            sum -= a[i];
        }
        out.ansln(ans);
    }
}
