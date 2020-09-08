package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class ATheBeatles {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs(), k = in.longs(), nk = n * k;
        long a = in.longs(), b = in.longs();
        long[] am = {a, -a}, bm = {b, -b};
        long x = Long.MAX_VALUE, y = Long.MIN_VALUE;
        for (long i = 1 - n; i < n; i++) {
            for (long an : am) {
                for (long bn : bm) {
                    long l = Math.abs(i * k + an + bn);
                    if (l == 0) {
                        l = nk;
                    }
                    long v = nk / IntMath.gcd(nk, l);
                    x = Math.min(x, v);
                    y = Math.max(y, v);
                }
            }
        }
        out.ans(x).ans(y).ln();
    }
}
