package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;

public class FCapture {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] x = new long[n], s = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.longs();
            s[i] = in.longs();
        }
        IntLazySegmentTree st = new IntLazySegmentTree(new long[n], Long::max, 0, Long::sum, Long::sum, 0);
        long ans = 0, last = x[0];
        for (int i = 0; i < n; i++) {
            st.update(0, i + 1, s[i]);
            st.update(0, i, last - x[i]);
            last = x[i];
            ans = Math.max(ans, st.query(0, i + 1));
        }
        out.ans(ans).ln();
    }
}
