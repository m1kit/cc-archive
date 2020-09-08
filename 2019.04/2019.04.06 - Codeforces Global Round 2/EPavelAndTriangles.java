package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EPavelAndTriangles {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long remain = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long p = Math.min(remain, a[i] / 2);
            ans += p;
            a[i] -= p * 2;
            remain -= p;
            ans += a[i] / 3;
            remain += a[i] % 3;
        }
        out.ansln(ans);
    }
}
