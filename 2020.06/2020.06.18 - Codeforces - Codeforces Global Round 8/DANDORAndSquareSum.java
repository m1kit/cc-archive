package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DANDORAndSquareSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(),p=0;
        int[] cnt = new int[20];
        for (int i = 0; i < n; i++) {
            long a = in.ints();
            for (int j = 0; j < 20; j++) {
                if (a % 2 == 1) {
                    cnt[j]++;
                    p++;
                }
                a /= 2;
            }
        }
        long ans = 0;
        while (p > 0) {
            long x = 0;
            for (int i = 0; i < 20; i++) {
                if (cnt[i] != 0) {
                    p--;
                    cnt[i]--;
                    x |= 1L << i;
                }
            }
            ans += x * x;
        }
        out.ans(ans).ln();

    }
}
