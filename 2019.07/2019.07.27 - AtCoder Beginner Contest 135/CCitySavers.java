package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CCitySavers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n + 1), b = in.longs(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = Math.min(a[i], b[i]);
            b[i] -= left;
            long right = Math.min(a[i + 1], b[i]);
            ans += left + right;
            a[i + 1] -= right;
        }
        out.ans(ans).ln();
    }
}
