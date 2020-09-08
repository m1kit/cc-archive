package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class FDISCOSMOS {

    private static final int MOD = (int) 1e9 + 7;
    private static final ModMath mod = new ModMath(MOD);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long h = in.longs(), w = in.longs(), t = in.longs();
        out.ans(solve(h, w, t)).ln();
    }

    private static long solve(long h, long w, long t) {
        long hg = IntMath.gcd(h, t), wg = IntMath.gcd(w, t);
        long ans = mod.pow(2, w / wg) + mod.pow(2, h / hg) + mod.pow(2, IntMath.gcd(h / hg, w / wg))+ MOD - 3;
        return mod.pow(ans, (wg * hg) % (MOD - 1));
    }
}
