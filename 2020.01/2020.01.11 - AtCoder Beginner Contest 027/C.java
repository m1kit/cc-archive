package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        int msb = BitMath.msb(n);
        long x = 1L << msb;
        for (int i = 1; i < msb; i += 2) x |= 1L << i;
        out.ans((x <= n) == (msb % 2 == 0) ? "Aoki" : "Takahashi").ln();
    }
}
