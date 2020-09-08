package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class DShock {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            uf.union(a, b);
        }
        long total = n * (n - 1L) / 2 - m;
        long b1 = (n - uf.size(0)) * (long) uf.size(0);
        long b2 = (n - uf.size(1)) * (long) uf.size(1);
        out.ans(Math.max(total - b1, total - b2)).ln();
    }
}
