package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EEnumerateXorSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[][] sum = new int[30][n + 1];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < n; j++) {
                if ((a[j] & (1 << i)) == 0) {
                    sum[i][j + 1] = sum[i][j];
                } else {
                    sum[i][j + 1] = sum[i][j] + 1;
                }
            }
        }

        int x = 0;
        for (int i = 0; i < n; i++) {
            x ^= a[i];
            long ans = 0;
            for (int j = 0; j < 30; j++) {
                int cnt = sum[j][i + 1];
                if ((x & (1 << j)) == 0) {
                    ans += cnt * (1L << j);
                } else {
                    ans += (i + 1 - cnt) * (1L << j);
                }
            }
            out.ans(ans).ln();
        }
    }
}
