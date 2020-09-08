package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class D {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long x = in.longs(), p = in.longs(), a = in.longs(), b = in.longs();
        ModMath mod = new ModMath(p);
        if (b - a <= 100_000_000) {
            long pow = mod.pow(x, a);
            long ans = pow;
            for (long i = a; i < b; i++) {
                pow *= x;
                pow %= p;
                ans = Math.min(ans, pow);
            }
            out.ans(ans).ln();
        } else {
            for (int i = 1; i <= 1000; i++) {
                try {
                    long v = mod.log(x, i);
                    while (v < a) v += p - 1;
                    if (a <= v && v <= b) {
                        out.ans(i).ln();
                        return;
                    }
                } catch (RuntimeException ex) {
                }
            }
        }
    }
}
