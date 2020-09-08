package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BBornThisWay {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long ta = in.longs(), tb = in.longs();
        int k = in.ints();
        long[] a = in.longs(n), b = in.longs(m);
        if (n <= k || m <= k) {
            out.ans(-1).ln();
            return;
        }
        long max = -1;
        for (int i = 0; i <= k; i++) {
            int idx = ArrayUtil.lowerBound(b, a[i] + ta);
            if (idx + (k - i) < m) {
                max = Math.max(max, b[idx + k - i] + tb);
            } else {
                out.ans(-1).ln();
                return;
            }
        }
        out.ans(max).ln();
    }
}
