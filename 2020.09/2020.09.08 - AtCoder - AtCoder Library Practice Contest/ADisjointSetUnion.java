package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class ADisjointSetUnion {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), q = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < q; i++) {
            if (in.ints() == 0) {
                uf.union(in.ints(), in.ints());
            } else {
                out.ans(uf.find(in.ints()) == uf.find(in.ints()) ? 1 : 0).ln();
            }
        }
    }
}
