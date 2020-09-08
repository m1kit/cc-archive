package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntWeightedUnionFind;

public class DPeopleOnALine {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntWeightedUnionFind uf = new IntWeightedUnionFind(n);
        for (int i = 0; i < m; i++) {
            if (!uf.union(in.ints() - 1, in.ints() - 1, in.ints())) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
