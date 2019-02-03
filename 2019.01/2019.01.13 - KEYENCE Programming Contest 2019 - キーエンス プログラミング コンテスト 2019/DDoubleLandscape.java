package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class DDoubleLandscape {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int m = in.ints();
        int[] a = in.ints(n);
        int[] b = in.ints(m);
        int[] rowhint = new int[n * m + 1];
        int[] columnhint = new int[n * m + 1];
        Arrays.fill(rowhint, -1);
        Arrays.fill(columnhint, -1);
        for (int i = 0; i < n; i++) {
            if (columnhint[a[i]] >= 0) {
                out.ans(0).ln();
                return;
            }
            columnhint[a[i]] = i;
        }
        for (int i = 0; i < m; i++) {
            if (rowhint[b[i]] >= 0) {
                out.ans(0).ln();
                return;
            }
            rowhint[b[i]] = i;
        }

        long ans = 1;
        int rf = 0, cf = 0;
        for (int k = n * m; k > 0; k--) {
            if (rowhint[k] >= 0 && columnhint[k] >= 0) {
                rf++;
                cf++;
            } else if (rowhint[k] >= 0) {
                ans *= cf;
                ans %= MOD;
                rf++;
            } else if (columnhint[k] >= 0) {
                ans *= rf;
                ans %= MOD;
                cf++;
            } else {
                ans *= (cf * rf) - (n * m - k);
                ans %= MOD;
            }
        }
        out.ans(ans).ln();
    }
}
