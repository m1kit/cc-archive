package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DBannedK {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n), cnt = new int[n + 1];
        for (int i = 0; i < n; i++) cnt[a[i]]++;
        long ans = 0;
        for (int i = 1; i <= n; i++) ans += cnt[i] * (cnt[i] - 1L) / 2;
        for (int i = 0; i < n; i++) {
            out.ans(ans - cnt[a[i]] + 1).ln();
        }
    }
}
