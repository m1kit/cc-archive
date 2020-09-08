package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ABiscuitGenerator {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), t = in.ints();
        int ans = 0;
        for (int i = a; i <= t; i += a) {
            ans += b;
        }
        out.ans(ans).ln();
    }
}
