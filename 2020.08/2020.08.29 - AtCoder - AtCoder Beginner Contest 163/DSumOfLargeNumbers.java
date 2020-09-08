package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class DSumOfLargeNumbers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), k = in.ints();
        long ans = 0;
        for (int t = k; t <= n + 1; t++) {
            long min = t * (t - 1L) / 2;
            ans += n * (long) t - 2 * min + 1;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
