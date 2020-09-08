package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class H {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int a = Math.abs(in.ints() - in.ints());
            if (a == 0) {
                out.ans(-1).ln();
            } else {
                out.ans(a).ln();
            }
        }
    }
}
