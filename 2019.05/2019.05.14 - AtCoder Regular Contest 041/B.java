package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.string();
            for (int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 0) continue;
                a[i + 1][j] += b[i][j];
                b[i + 2][j] -= b[i][j];
                b[i + 1][j - 1] -= b[i][j];
                b[i + 1][j + 1] -= b[i][j];
                b[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print((char) (a[i][j] + '0'));
            }
            out.ln();
        }
    }
}
