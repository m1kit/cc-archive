package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BDimaAndABadXOR {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[][] a = in.ints(n, m);

        int diversity = -1;
        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (a[i][j] != a[i][j + 1]) {
                    diversity = i;
                    break outer;
                }
            }
        }
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= a[i][0];
        }
        if (diversity == -1 && xor == 0) {
            out.ansln("NIE");
            return;
        }

        int pivot = 0;
        if (xor == 0) {
            xor ^= a[diversity][0];
            pivot = -1;
            for (int i = 0; i < m; i++) {
                if ((xor ^ a[diversity][i]) != 0) {
                    pivot = i;
                    break;
                }
            }
        }

        out.ansln("TAK");
        for (int i = 0; i < n; i++) {
            if (i == diversity) {
                out.ans(pivot + 1);
            } else {
                out.ans(1);
            }
        }
        out.ln();
    }
}
