package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BIronBarCutting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long total = 0;
        long[] a = in.longs(n);
        for (int i = 0; i < n; i++) {
            total += a[i];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum >= total / 2) {
                out.ans(Math.min(2 * sum - total, total - 2 * (sum - a[i]))).ln();
                return;
            }
        }
    }
}
