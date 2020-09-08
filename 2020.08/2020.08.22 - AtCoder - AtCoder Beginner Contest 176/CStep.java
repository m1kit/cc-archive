package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CStep {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = 0;
        long pre = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < pre) {
                ans += pre - a[i];
                a[i] = pre;
            } else pre = a[i];
        }
        out.ans(ans).ln();
    }
}
