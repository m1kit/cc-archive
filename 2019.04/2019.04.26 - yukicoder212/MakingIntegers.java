package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class MakingIntegers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs(), k = in.longs();
        long max = (1L + n) * n / 2;
        long min = max - (n - k + 1 + n) * k;
        out.ans((max - min) / 2 + 1).ln();
    }
}
