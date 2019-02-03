package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        IntSegmentTree st = new IntSegmentTree(new long[200001], (x, y) -> x + y, 0);
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int t = in.ints(), x = in.ints();
            switch (t) {
                case 1: {
                    st.update(x, 1);
                    break;
                }
                case 2: {
                    int min = 1, max = 200001;
                    while (max - min > 1) {
                        int mid = (min + max) / 2;
                        if (st.query(0, mid) < x) {
                            min = mid;
                        } else {
                            max = mid;
                        }
                    }
                    st.update(min, 0);
                    out.println(min);
                    break;
                }
            }
        }
    }
}
