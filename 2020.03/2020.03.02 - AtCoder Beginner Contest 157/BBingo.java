package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBingo {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[][] b = in.ints(3, 3);
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (b[j][k] == x) b[j][k] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < 3; j++) {
                if (b[i][j] != 0) row = false;
                if (b[j][i] != 0) col = false;
            }
            if (row || col) {
                out.yesln();
                return;
            }
        }
        if (b[1][1] != 0) {
            out.noln();
            return;
        }
        out.ans((b[0][0] == 0 && b[2][2] == 0) || (b[0][2] == 0 && b[2][0] == 0)).ln();
    }
}
