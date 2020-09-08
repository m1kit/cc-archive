package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CPrison {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int l = 1, r = n;
        for (int i = 0; i < m; i++) {
            int x = in.ints(), y = in.ints();
            l = Math.max(l, x);
            r = Math.min(r, y);
        }
        out.ans(Math.max(0, r - l + 1)).ln();
    }
}
