package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DRoadToMillionaire {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long now = 1000, ans = 1000, stock = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && a[i] > a[i + 1]) {
                now += stock * a[i];
                stock = 0;
            } else {
                stock += now / a[i];
                now %= a[i];
            }
            ans = Math.max(ans, now + stock * a[i]);
        }
        out.ans(ans).ln();
    }
}
