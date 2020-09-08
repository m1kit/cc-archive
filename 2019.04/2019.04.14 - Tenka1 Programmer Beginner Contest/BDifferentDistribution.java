package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BDifferentDistribution {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ints(), b = in.ints();
            min = Math.min(min, b);
            max = Math.max(max, a);
        }
        out.ansln(max + min);
    }
}
