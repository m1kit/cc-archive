package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CRamessesAndCornerInversion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();//h = n, w = m
        int[][] a = in.ints(n, m), b = in.ints(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == b[i][j]) {
                    continue;
                }
                int id = -1;
                for (int k = i + 1; k < n; k++) {
                    if (a[k][j] != b[k][j]) {
                        id = k;
                        break;
                    }
                }
                int jd = -1;
                for (int k = j + 1; k < m; k++) {
                    if (a[i][k] != b[i][k]) {
                        jd = k;
                        break;
                    }
                }
                if (id == -1 || jd == -1) {
                    out.noln();
                    return;
                }
                a[id][j] = b[id][j];
                a[i][jd] = b[i][jd];
                a[id][jd] = 1 - a[id][jd];
            }
        }
        out.yesln();
    }
}
