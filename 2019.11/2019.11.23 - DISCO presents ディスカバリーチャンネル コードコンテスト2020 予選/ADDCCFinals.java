package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADDCCFinals {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int x = in.ints(), y = in.ints();
        int ans = 0;
        int[] p = {0, 300000, 200000, 100000};
        if (x <= 3) ans += p[x];
        if (y <= 3) ans += p[y];
        if (x == 1 && y == 1) ans += 400000;
        out.ans(ans).ln();
    }
}
