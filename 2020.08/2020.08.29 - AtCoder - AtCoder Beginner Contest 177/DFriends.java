package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class DFriends {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        int ans = 1;
        for (int i = 0; i < m; i++) {
            uf.union(in.ints() - 1, in.ints()- 1);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, uf.size(i));
        }
        out.ans(ans).ln();
    }
}
