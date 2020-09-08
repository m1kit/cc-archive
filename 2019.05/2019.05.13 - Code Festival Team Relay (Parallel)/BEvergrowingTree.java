package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BEvergrowingTree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), q = in.ints();
        for (int i = 0; i < q; i++) {
            long v = in.longs(), w = in.longs();
            if (n == 1) {
                out.ans(Math.min(v, w)).ln();
            } else {
                long dv = depth(v, n), dw = depth(w, n);
                for (int j = 0; j < dv - dw; j++) v = par(v, n);
                for (int j = 0; j < dw - dv; j++) w = par(w, n);
                while (v != w) {
                    v = par(v, n);
                    w = par(w, n);
                }
                out.ans(v).ln();
            }
        }
    }

    private static long par(long x, long n) {
        return (x + n - 2) / n;
    }

    private static long depth(long x, long n) {
        long res = 0;
        while (x != 1) {
            x = par(x, n);
            res++;
        }
        return res;
    }
}
