package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class CBridge {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        int[] a = new int[m], b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.ints() - 1;
            b[i] = in.ints() - 1;
            uf.union(a[i], b[i]);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            IntUnionFind uf2 = new IntUnionFind(n);
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                uf2.union(a[j], b[j]);
            }
            if (uf.size() != uf2.size()) {
                ans++;
            }
        }
        out.ansln(ans);
    }
}
