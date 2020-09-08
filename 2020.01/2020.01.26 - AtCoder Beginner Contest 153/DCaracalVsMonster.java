package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DCaracalVsMonster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long h = in.longs();
        long k = 1, ans = 0;
        while (h > 0) {
            ans += k;
            h /= 2;
            k *= 2;
        }
        out.ans(ans).ln();
    }
}
