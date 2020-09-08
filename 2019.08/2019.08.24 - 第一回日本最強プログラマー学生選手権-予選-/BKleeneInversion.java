package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BKleeneInversion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long k = in.longs();
        int[] a = in.ints(n);
        int[] all = new int[2001], cnt = new int[2001];
        long ans = 0;
        for (int i = 0; i < n; i++) all[a[i]]++;
        for (int i = 0; i < n; i++) {
            long zero = 0, delta = 0;
            for (int j = a[i] + 1; j <= 2000; j++) {
                zero += cnt[j];
                delta += all[j];
            }
            ans += k * zero % MOD;
            ans %= MOD;
            long c = k * (k - 1L) / 2 % MOD;
            ans += c * delta % MOD;
            ans %= MOD;

            cnt[a[i]]++;
        }
        out.ans(ans).ln();
    }
}
