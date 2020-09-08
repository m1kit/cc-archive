package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

public class BBalancedTunnel {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n);
        int[] incoming = new int[n], outgoing = new int[n];
        for (int i = 0; i < n; i++) {
            incoming[a[i] - 1] = i;
            outgoing[b[i] - 1] = i;
        }
        IntSegmentTree st = new IntSegmentTree(new long[n], Long::sum, 0, Long::sum);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += st.query(outgoing[a[i] - 1], n) > 0 ? 1 : 0;
            st.update(outgoing[a[i] - 1], 1);
        }
        out.ans(ans).ln();
    }
}
