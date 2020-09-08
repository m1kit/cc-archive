package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class CNewsDistribution {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            int k = in.ints();
            int[] a = in.ints(k);
            for (int j = 1; j < k; j++) {
                uf.union(a[j - 1] - 1, a[j] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            out.ans(uf.size(i));
        }
        out.ln();
    }
}
