package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.Arrays;

public class CRumor {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        int[] c = in.ints(n);
        int[] a = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            uf.union(in.ints() - 1, in.ints() - 1);
        }

        for (int i = 0; i < n; i++) {
            int g = uf.find(i);
            a[g] = Math.min(a[g], c[i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != Integer.MAX_VALUE) {
                ans += a[i];
            }
        }
        out.ans(ans).ln();
    }
}
