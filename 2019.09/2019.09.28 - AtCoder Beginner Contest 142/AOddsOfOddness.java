package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AOddsOfOddness {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int c = 0;
        int n = in.ints();
        for (int i  = 1; i <= n; i++) {
            if (i % 2 == 1)c++;
        }
        out.ans(c / (double) n, 10).ln();
    }
}
