package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AThumbnail {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int d = Integer.MAX_VALUE;
        int idx = -1;
        int n = in.ints();
        int[] a = in.ints(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i] * n - sum) < d) {
                idx = i;
                d = Math.abs(a[i] * n - sum);
            }
        }
        out.ansln(idx);
    }
}
