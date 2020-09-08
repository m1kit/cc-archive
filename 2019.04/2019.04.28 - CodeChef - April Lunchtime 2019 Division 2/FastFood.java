package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FastFood {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n), b = in.ints(n);
            int[] x = new int[n + 1], y = new int[n + 1];
            for (int i = 0; i < n; i++) {
                x[i + 1] = x[i] + a[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                y[i] = y[i + 1] + b[i];
            }
            long ans = 0;
            for (int i = 0; i <= n; i++) {
                ans = Math.max(ans, x[i] + y[i]);
            }
            out.ans(ans).ln();
        }
    }
}
