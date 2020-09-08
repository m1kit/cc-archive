package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DYetAnotherYetAnotherTask {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int ans = 0;
        for (int lim = 1; lim <= 31; lim++) {
            int sum = 0, max = -30;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                max = Math.max(max, a[i]);
                if (sum < 0 || lim <= max) {
                    sum = 0;
                    max = -30;
                } else {
                    ans = Math.max(ans, sum - max);
                }
            }
        }
        out.ans(ans).ln();
    }
}
