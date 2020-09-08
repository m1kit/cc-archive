package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int m = in.ints(), n = in.ints(), l = in.ints();
        int s = l;
        int ans = l;
        while (s >= m) {
            ans += s / m * n;
            s = (s % m) + (s / m * n);
        }
        out.ans(ans).ln();
    }
}
