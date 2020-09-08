package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CLower {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int last = 0, streak = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= last) {
                ans = Math.max(ans, ++streak);
            } else {
                streak = 0;
            }
            last = a[i];
        }
        out.ans(ans).ln();
    }
}
