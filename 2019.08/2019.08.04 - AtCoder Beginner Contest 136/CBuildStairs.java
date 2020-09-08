package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CBuildStairs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) {
                a[i]--;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
