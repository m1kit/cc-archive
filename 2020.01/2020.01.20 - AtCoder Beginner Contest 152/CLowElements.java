package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CLowElements {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            if (x < min) {
                ans++;
                min = x;
            }
        }
        out.ans(ans).ln();
    }
}
