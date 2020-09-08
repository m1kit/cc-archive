package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class DCowAndSnacks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int sad = 0;
        int n = in.ints(), k = in.ints();
        IntUnionFind uf =new IntUnionFind(n);
        for (int i = 0; i < k; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            if (uf.find(x) == uf.find(y)) sad++;
            else uf.union(x, y);
        }
        out.ans(sad).ln();
    }
}
