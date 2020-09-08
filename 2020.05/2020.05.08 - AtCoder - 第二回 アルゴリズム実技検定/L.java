package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.SegmentTree;
import dev.mikit.atcoder.lib.structure.sparsetable.SparseTable;

public class L {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints(), d = in.ints(), lo = 0;
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) ps[i] = new P(i, in.ints());
        if (n < d * (k - 1) + 1) {
            out.ans(-1).ln();
            return;
        }
        SparseTable<P> st = new SparseTable<>(ps, (x, y) -> x.v <= y.v ? x : y);
        for (int i = 0; i < k; i++) {
            int hi = (int) (n - d * (k - i - 1L));
            P p = st.query(lo, hi);
            out.ans(p.v);
            lo = p.index + d;
        }
        out.ln();
    }

    private static class P {
        int index, v;

        P(int index, int v) {
            this.index = index;
            this.v = v;
        }
    }
}
