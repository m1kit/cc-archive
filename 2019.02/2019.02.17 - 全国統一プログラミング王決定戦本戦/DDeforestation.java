package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.IntLazySegmentTree;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

public class DDeforestation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints();
        long ct = 0;
        long[] bamboo = new long[n];
        IntLazySegmentTree st = new IntLazySegmentTree(bamboo, (x, y) -> x + y, 0, (x, q) -> q, (q1, q2) -> q2, 0, (q, t) -> q);
        long ans = 0;
        for (int i = 0; i < m; i++) {
            long t = in.longs();
            int l = in.ints() - 1, r = in.ints();
            st.update(l, r, t);
        }
        for (int i = 0; i < n; i++) {
            ans += st.query(i, i + 1);
        }
        out.ansln(ans);
    }
}
