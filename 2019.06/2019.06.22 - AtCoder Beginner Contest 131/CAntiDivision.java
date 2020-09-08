package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CAntiDivision {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.longs(), b = in.longs(), c = in.longs(), d = in.longs();
        long ans = b - a + 1;
        ans -= cnt(a, b, c);
        ans -= cnt(a, b, d);
        ans += cnt(a, b, IntMath.lcm(c, d));
        out.ans(ans).ln();
    }

    private static long cnt(long a, long b, long d) {
        return b / d - ((a - 1L) / d);
    }
}
