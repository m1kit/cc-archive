package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BCanYouSolveThis {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), c = in.ints();
        int[] b = in.ints(m);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] a = in.ints(m);
            long val = c;
            for (int j = 0; j < m; j++) {
                val += b[j] * a[j];
            }
            if (val > 0) {
                ans++;
            }
        }
        out.ansln(ans);
    }
}
