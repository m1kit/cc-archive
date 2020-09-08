package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BSquareFilling {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[][] a = in.ints(n, m);
        boolean[][] ok = new boolean[n][m];
        boolean[][] op = new boolean[n][m];
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (a[i][j] * a[i + 1][j] * a[i][j + 1] * a[i + 1][j + 1] == 1) {
                    op[i][j] = true;
                    k++;
                    ok[i][j] = ok[i + 1][j] = ok[i][j + 1] = ok[i + 1][j + 1] = true;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !ok[i][j]) ans = false;
            }
        }
        if (!ans) {
            out.ans(-1).ln();
            return;
        }
        out.ans(k).ln();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (op[i][j]) out.ans(i + 1).ans(j + 1).ln();
            }
        }
    }
}
