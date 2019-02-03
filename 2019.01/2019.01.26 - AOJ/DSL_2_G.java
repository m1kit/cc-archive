package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.IntLazySegmentTree;

import java.util.Arrays;

public class DSL_2_G {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), queries = in.ints();
        long[] a = new long[n];
        IntLazySegmentTree st = new IntLazySegmentTree(a, (x, y) -> x + y, 0,
                (x, q) -> x + q, (q1, q2) -> q1 + q2, 0, (q, m) -> q * m);
        for (int i = 0; i < queries; i++) {
            int com = in.ints();
            if (com == 0) {
                int s = in.ints() - 1, t = in.ints() - 1, x = in.ints();
                st.update(s, t + 1, x);
            } else {
                int s = in.ints() - 1, t = in.ints() - 1;
                out.ans(st.query(s, t + 1)).ln();
            }
        }
    }
}
// 1 3 5