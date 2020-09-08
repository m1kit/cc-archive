package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.euclid.LongEuclidSolver;
import dev.mikit.atcoder.lib.structure.fenwicktree.AbelianIntFenwickTree;
import dev.mikit.atcoder.lib.structure.fenwicktree.IntFenwickTree;

public class BFenwickTree {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), q = in.ints();
        AbelianIntFenwickTree bit = new AbelianIntFenwickTree(in.longs(n), Long::sum, 0L, x -> -x);
        for (int i = 0; i < q; i++) {
            if (in.ints() == 0) {
                bit.add(in.ints(), in.ints());
            } else {
                out.ans(bit.query(in.ints(), in.ints())).ln();
            }
        }
    }
}
