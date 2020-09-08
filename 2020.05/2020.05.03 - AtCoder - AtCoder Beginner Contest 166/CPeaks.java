package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class CPeaks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int n = in.ints(), m = in.ints();
        int[] h = in.ints(n);
        int[] max = new int[n];
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            max[x] = Math.max(max[x], h[y]);
            max[y] = Math.max(max[y], h[x]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (max[i] < h[i]) ans++;
        }
        out.ans(ans).ln();
    }
}
