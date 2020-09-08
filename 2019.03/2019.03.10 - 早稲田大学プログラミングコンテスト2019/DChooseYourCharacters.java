package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

import java.util.ArrayList;
import java.util.List;

public class DChooseYourCharacters {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        IntSegmentTree st = new IntSegmentTree(new long[n], Math::max, 0, (x, y) -> x + y);
        List<List<Integer>> hate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hate.add(new ArrayList<>());
            hate.get(i).add(i);
        }
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            hate.get(b).add(a);
        }


        int min = n + 1;
        int minl = -1, minr = -1;

        int l = 0;
        for (int r = 0; r < n; r++) {
            for (int h : hate.get(r)) {
                st.update(h, 1);
            }
            if (st.query(0, n) >= (r - l + 1)) {
                continue;
            }

            while (l <= r && st.query(0, n) < (r - l + 1)) {
                //System.out.println("l=" + l + " r=" + r);
                //System.out.println("q="+(st.query(0, n)));
                for (int h : hate.get(l)) {
                    st.update(h, -1);
                }
                l++;
            }

            if (r - l + 2 < min) {
                min = r - l + 2;
                minl = l - 1;
                minr = r;
            }
        }
        if (min == n + 1) {
            out.ansln(-1);
        } else {
            out.ans(minl + 1).ans(minr + 1).ln();
        }
    }
}
