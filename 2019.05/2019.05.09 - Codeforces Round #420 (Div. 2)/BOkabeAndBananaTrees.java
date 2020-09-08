package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BOkabeAndBananaTrees {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long m = in.longs(), b = in.longs();

        long max = 0;
        for (long y = 0; y <= b; y++) {
            // ()
            long x = m * (b - y);
            long ans = (x * (x + 1) * (y + 1) + y * (y + 1) * (x + 1)) / 2;
            max = Math.max(ans, max);
        }
        out.ans(max).ln();
    }
}
