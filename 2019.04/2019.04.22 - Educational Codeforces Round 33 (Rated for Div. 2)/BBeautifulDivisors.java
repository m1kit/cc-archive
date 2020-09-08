package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBeautifulDivisors {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        for (int i = 20; i >= 1; i--) {
            long div = ((1L << i) - 1) * (1L << (i - 1));
            if (n % div == 0) {
                out.ans(div).ln();
                return;
            }
        }
    }
}
