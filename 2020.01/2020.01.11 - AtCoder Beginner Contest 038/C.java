package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), len = 1;
        long ans = 0;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) a[i] = in.ints();
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] >= a[i]) {
                ans += len * (len + 1L) / 2;
                len = 1;
            } else len++;
        }
        out.ans(ans).ln();
    }
}
