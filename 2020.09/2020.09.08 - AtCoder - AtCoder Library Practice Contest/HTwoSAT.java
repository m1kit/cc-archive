package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.misc.OrderedCompressor;
import dev.mikit.atcoder.lib.misc.TwoSat;

import java.util.List;

public class HTwoSAT {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long d = in.longs();
        long[] x = new long[n], y = new long[n], z = new long[2 * n];
        in.longs(x, y);
        // 座標圧縮
        System.arraycopy(x, 0, z, 0, n);
        System.arraycopy(y, 0, z, n, n);
        OrderedCompressor cmp = new OrderedCompressor(z);
        // 2-SAT
        int m = cmp.size();
        TwoSat sat = new TwoSat(m);
        for (int i = 0; i < n; i++) sat.or(cmp.map(x[i]) + 1, cmp.map(y[i]) + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (cmp.unmap(i) - cmp.unmap(j) >= d) continue;
                sat.or(-1 - i, -1 - j);
            }
        }
        boolean[] res = sat.solve();
        if (res == null) {
            out.noln();
            return;
        }
        out.yesln();
        for (int i = 0; i < n; i++) {
            out.ans(res[cmp.map(x[i])] ? x[i] : y[i]).ln();
        }
    }
}
