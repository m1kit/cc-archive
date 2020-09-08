package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AIntegerProduct {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            String[] s = in.string().split("\\.");
            if (s.length == 2) {
                a[i] = Long.parseLong(s[1]);
                int len = s[1].length();
                for (int j = len; j < 9; j++) {
                    a[i] *= 10;
                }
            }
            a[i] += Long.parseLong(s[0]) * 1_000_000_000L;

        }
        int[][] tbl = new int[19][19];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int c2 = 0, c5 = 0;
            while (a[i] %  2 == 0) {
                a[i] /= 2;
                c2++;
            }
            while (a[i] %  5 == 0) {
                a[i] /= 5;
                c5++;
            }
            c2 = Math.min(c2, 18);
            c5 = Math.min(c5, 18);
            for (int j = 18 - c2; j <= 18; j++) {
                for (int k = 18 - c5; k <= 18; k++) {
                    ans += tbl[j][k];
                }
            }
            tbl[c2][c5]++;
        }
        out.ans(ans).ln();
    }
}
