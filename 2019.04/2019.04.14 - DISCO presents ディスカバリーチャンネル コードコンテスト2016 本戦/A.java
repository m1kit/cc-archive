package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int r = in.ints(), c = in.ints();
        int ans = 0;
        for (int x = c; x <= r; x += c) {
            for (int y = c; y <= r; y += c) {
                if ((x * x) + (y * y) <= (r * r)) {
                    ans += 4;
                }
            }
        }
        out.ansln(ans);
    }
}
