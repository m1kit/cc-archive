package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class TwoSat {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        in.voids();
        in.voids();
        int n = in.ints(), m = in.ints();
        dev.mikit.atcoder.lib.misc.TwoSat sat = new dev.mikit.atcoder.lib.misc.TwoSat(n);
        for (int i = 0; i < m; i++) {
            sat.or(in.ints(), in.ints());
            in.voids();
        }
        boolean[] result = sat.solve();
        if (result == null) {
            out.ans("s UNSATISFIABLE").ln();
            return;
        }
        out.ans("s SATISFIABLE").ln().ans("v");
        for (int i = 0; i < n; i++) {
            if (result[i]) out.ans(i + 1);
            else out.ans(-1 - i);
        }
        out.ans(0).ln();
    }
}
