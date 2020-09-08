package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] t = in.ints(n);
        int ans = 1000000;
        for (int i = 0; i < (1 << n); i++) {
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    x += t[j];
                } else {
                    y += t[j];
                }
            }
            ans = Math.min(ans, Math.max(x, y));
        }
        out.ans(ans).ln();
    }
}
