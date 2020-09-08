package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class CEdgyTrees {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 1; i < n; i++) {
            int u = in.ints() - 1, v = in.ints() - 1, x = in.ints();
            if (x == 1) {
                continue;
            }
            uf.union(u, v);
        }

        ModMath mod = new ModMath(MOD);
        long ans = mod.pow(n, k);

        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            int g = uf.find(i);
            if (done[g]) {
                continue;
            }
            done[g] = true;
            long siz = uf.size(i);
            ans -= mod.pow(siz, k);
            ans += MOD;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
