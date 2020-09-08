package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DChecker {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[][] a = new int[k + 1][k + 1];
        int base = 0;
        for (int i = 0; i < n; i++) {
            int x = in.ints() % (2 * k), y = in.ints() % (2 * k), d = "B".equals(in.string()) ? 1 : - 1;
            if (x >= k) {
                x -= k;
                d *= -1;
            }
            if (y >= k) {
                y -= k;
                d *= -1;
            }
            if (d == -1) base++;
            a[y + 1][x + 1] += d;
        }

        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                a[i + 1][j + 1] += a[i][j + 1] + a[i + 1][j] - a[i][j];

        int ans = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                ans = Math.max(ans, a[i][j] + a[k][k] - a[i][k] - a[k][j] + a[i][j]);
                ans = Math.max(ans, a[i][k] + a[k][j] - 2 * a[i][j]);
            }
        }
        out.ans(ans + base).ln();
    }
}
