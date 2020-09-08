package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] t = in.ints(n);
        for (int i = 2; i < n; i++) {
            if (t[i - 2] + t[i - 1] + t[i] < k) {
                out.ans(i + 1).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
