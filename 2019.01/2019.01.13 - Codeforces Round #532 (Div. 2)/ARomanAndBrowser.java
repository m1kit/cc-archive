package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class ARomanAndBrowser {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        int ans = 0;
        int sum = Arrays.stream(a).sum();
        for (int b = 0; b < k; b++) {
            int v = sum;
            for (int i = b; i < n; i += k) {
                v -= a[i];
            }
            ans = Math.max(ans, Math.abs(v));
        }
        out.ans(ans).ln();
    }
}
