package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), t = in.ints();
        long[] a = in.longs(n);
        long min = Integer.MAX_VALUE, max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] - min > max) {
                max = a[i] - min;
                cnt = 1;
            } else if (a[i] - min == max) cnt++;
        }
        //System.out.println(max);
        out.ans(cnt).ln();
    }
}
