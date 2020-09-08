package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBiteEating {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), l = in.ints();
        long sum = 0, min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += l + i;
            if (Math.abs(l + i) < Math.abs(min)) {
                min = l + i;
            }
        }
        out.ans(sum - min).ln();
    }
}
