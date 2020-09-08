package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class E {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.ints() - 1;
        for (int i = 0; i < n; i++) {
            int now = a[i], ans = 1;
            while (now != i) {
                now = a[now];
                ans++;
            }
            out.ans(ans);
        }
        out.ln();
    }
}
