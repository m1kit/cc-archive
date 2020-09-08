package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CCandies {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n);
        for (int i = 1; i < n; i++) a[i] += a[i - 1];
        for (int i = n - 2; i >= 0; i--) b[i] += b[i + 1];
        int ans = 0;
        for (int i = 0; i < n; i++)  ans = Math.max(ans, a[i] + b[i]);
        out.ans(ans).ln();
    }
}
