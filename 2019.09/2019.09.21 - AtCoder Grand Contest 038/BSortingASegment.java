package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

public class BSortingASegment {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] p = in.longs(n);
        int[] sorted = new int[n];
        int dup = 0;
        sorted[0] = 1;
        for (int i = 1; i < n; i++) {
            if (p[i - 1] < p[i]) sorted[i] = sorted[i - 1] + 1;
            else sorted[i] = 1;
            if (sorted[i] >= k) dup++;
        }
        dup = Math.max(0, dup - 1);
        IntSegmentTree min = new IntSegmentTree(p, Math::min, n, Math::min);
        IntSegmentTree max = new IntSegmentTree(p, Math::max, 0, Math::max);
        for (int i = 1; i < n - k + 1; i++) {
            if (sorted[i + k - 1] >= k) continue;
            long lo = min.query(i - 1, i - 1 + k);
            long up = max.query(i - 1, i - 1 + k);
            if ((lo == p[i - 1] && up < p[i + k - 1])) {
                dup++;
            }
        }
        out.ans(n - k + 1 - dup).ln();
    }
}
