package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class E1Or2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1, z = in.ints();
            uf.union(x, y);
        }
        out.ans(uf.size()).ln();
    }
}
