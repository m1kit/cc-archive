package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.LongChineseRemainder;

public class DSemiCommonMultiple {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long lcm = 1, m = in.longs();
        boolean[] p = new boolean[2];
        long[] a = in.longs(n);
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                out.ans(0).ln();
                return;
            }
        }

        LongChineseRemainder cr = new LongChineseRemainder();
        try {
            for (int i = 0; i < n; i++) {
                cr.grow(a[i] / 2, a[i]);
                if (cr.getRemainder() > m) throw new RuntimeException();
            }
        } catch (RuntimeException ex) {
            out.ans(0).ln();
            return;
        }
        out.ans((m - cr.getRemainder()) / cr.getModulo() + 1).ln();
    }
}
