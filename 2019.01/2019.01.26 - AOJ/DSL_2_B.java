package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.IntLazySegmentTree;

import java.util.Arrays;

public class DSL_2_B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();

        int n = in.ints(), q = in.ints();
        long[] a = new long[n];
        //IntSegmentTree st = new IntSegmentTree(a, Math::min, Integer.MAX_VALUE);
        IntLazySegmentTree lst = new IntLazySegmentTree(a, (x, y) -> x + y, 0);
        for (int i = 0; i < q; i++) {
            int com = in.ints(), x = in.ints(), y = in.ints();
            if (com == 0) {
                //st.update(x, y);
                lst.update(x - 1, lst.get(x - 1) + y);
            } else {
                //long r1 = st.query(x, y + 1);
                long r2 = lst.query(x - 1, y);
                out.ans(r2).ln();
            }
        }
    }
}
