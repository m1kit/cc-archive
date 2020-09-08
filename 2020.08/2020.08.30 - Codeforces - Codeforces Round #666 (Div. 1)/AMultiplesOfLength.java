package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.euclid.LongEuclidSolver;
import dev.mikit.atcoder.lib.math.geo.Vec3l;

public class AMultiplesOfLength {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long[] a = in.longs(n);
        if (n == 1) {
            out.ans(1).ans(1).ln().ans(-a[0]).ln();
            out.ans(1).ans(1).ln().ans(0).ln();
            out.ans(1).ans(1).ln().ans(0).ln();
            return;
        } else if (n == 2) {
            out.ans(1).ans(1).ln().ans(-a[0]).ln();
            out.ans(2).ans(2).ln().ans(-a[1]).ln();
            out.ans(1).ans(1).ln().ans(0).ln();
            return;
        }
        Vec3l sol = LongEuclidSolver.solve(n, n - 1);
        if (sol.z != 1) throw new RuntimeException();
        long[] p1 = new long[n], p2 = new long[n];
        for (int i = 0; i < n; i++) {
            p1[i] = -n * a[i] * sol.x;
            p2[i] = -(n - 1L) * a[i] * sol.y;
        }
        // 1
        out.ans(1).ans(n).ln();
        for (int i = 0; i < n - 1; i++) {
            out.ans(p1[i]);
            a[i] += p1[i];
        }
        out.ans(0).ln();
        // 2
        out.ans(1).ans(n - 1).ln();
        for (int i = 0; i < n - 1; i++) {
            out.ans(p2[i]);
            a[i] += p2[i];
        }
        out.ln();
        //3
        out.ans(n).ans(n).ln().ans(-a[n - 1]).ln();
        a[n - 1] = 0;
        /*
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) throw new RuntimeException();
        }*/
    }
}
