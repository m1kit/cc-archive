package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CXYetAnotherDieGame {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long x = in.longs();
        long ans = x / 11 * 2;
        x %= 11;
        if (x > 6) {
            ans += 2;
        } else if (x > 0) {
            ans += 1;
        }
        out.ansln(ans);
    }
}
