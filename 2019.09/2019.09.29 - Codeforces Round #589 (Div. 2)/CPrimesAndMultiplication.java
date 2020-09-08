package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class CPrimesAndMultiplication {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long x = in.longs(), n = in.longs();
        long ans = 1;
        ModMath mod = new ModMath(MOD);
        for (long p : IntMath.primeFactorize(x).keySet()) {
            long t = n;
            while (p <= t) {
                t /= p;
                ans *= mod.pow(p, t);
                ans %= MOD;
            }
        }
        out.ans(ans).ln();
    }
}
