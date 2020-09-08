package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BNewYearAndOldProperty {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), b = in.longs(), ans = 0;
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < i - 1; j++) {
                long x = ((1L << i) - 1) & ~(1L << j);
                if (a <= x && x <= b) ans++;
            }
        }
        out.ans(ans).ln();
    }
}
