package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;

public class FWiFi {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        char[] a = in.string().toCharArray();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        IntSegmentTree st = new IntSegmentTree(dp, Math::min, Long.MAX_VALUE, Math::min);
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] == '1') {
                long v = st.query(Math.max(0, i - k - 1), Math.min(i + k, n));
                if (v != Long.MAX_VALUE) {
                    st.update(Math.min(n, i + k), v + i);
                }
            }
            st.update(i, st.get(i - 1) + i);
        }
        out.ans(st.get(n)).ln();
    }
}
