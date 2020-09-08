package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

public class ENumberOfComponents {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long ans = (n - a[0] + 1L) * a[0];
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) continue;
            if (a[i - 1] < a[i]) {
                ans += (a[i] - a[i - 1]) * (n - a[i] + 1L);
            } else {
                ans += (a[i - 1] - a[i]) * (long) a[i];
            }
        }
        out.ansln(ans);
    }
}
