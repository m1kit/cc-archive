package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class CSumOfProductOfPairs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * sum % MOD;
            ans %=MOD;
            sum += a[i];
            sum %= MOD;
        }
        out.ans(ans).ln();
    }
}
