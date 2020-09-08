package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSpecialCakeForCODEFESTIVAL {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        boolean[][] res = new boolean[n][n];
        res[0][0] = res[n - 1][0] = res[0][n - 1] = res[n - 1][n - 1] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + 2 * j) % 5 == 0) res[i][j] = true;
            }
            if (i % 3 == 0) res[i][0] = res[0][i] = res[n - 1][i] = res[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(res[i][j] ? 'X' : '.');
            }
            out.ln();
        }
    }
}
