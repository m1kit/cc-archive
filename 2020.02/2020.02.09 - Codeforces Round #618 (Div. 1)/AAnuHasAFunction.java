package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.sparsetable.IntSparseTable;

public class AAnuHasAFunction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long max = 0;
        int maxIndex = 0;
        IntSparseTable st = new IntSparseTable(a, (x, y) -> x | y);
        for (int i = 0; i < n; i++) {
            long f = 0;
            if (0 < i) f |= st.query(0, i);
            if (i < n - 1) f |= st.query(i + 1, n);
            long x = (a[i] | f) - f;
            if (x > max) {
                max = x;
                maxIndex = i;
            }
        }
        out.ans(a[maxIndex]);
        for (int i = 0; i < n; i++) {
            if (i == maxIndex) continue;
            out.ans(a[i]);
        }
        out.ln();
    }
}
