package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

public class J {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        int m = 100_001;
        int[] a = in.ints(n);
        long[] count = new long[m];
        IntSegmentTree st = new IntSegmentTree(count, (x, y) -> x + y, 0, (x, q) -> x + q);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += st.query(a[i] + 1, m);
            st.update(a[i], 1);
        }
        out.ansln(ans);
    }
}
