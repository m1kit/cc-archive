package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class GDivision {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), pow = 1;
        int[] group = new int[n];
        long[][] a = new long[n][n];

        for (int i = 0; i < n; i++) {
            pow *= 3;
            for (int j = i + 1; j < n; j++) a[i][j] = a[j][i] = in.longs();
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < pow; i++) {
            int t = i;
            long v = 0;
            for (int j = 0; j < n; j++) {
                group[j] = t % 3;
                t /= 3;
            }
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (group[j] == group[k]) v += a[j][k];
                }
            }
            ans = Math.max(ans, v);
        }
        out.ans(ans).ln();
    }
}
