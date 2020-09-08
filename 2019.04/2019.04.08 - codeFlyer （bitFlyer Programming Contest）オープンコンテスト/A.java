package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] p = in.ints(n);
        int ans = 10000000;
        for (int i = 0; i < n; i++) {
            int c = 0;
            while (p[i] % 10 == 0) {
                p[i] /= 10;
                c++;
            }
            ans = Math.min(ans, c);
        }
        out.ansln(ans);
    }
}
