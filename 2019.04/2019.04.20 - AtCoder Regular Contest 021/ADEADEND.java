package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADEADEND {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[][] a = in.ints(4, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == a[i][j + 1] || a[j][i] == a[j + 1][i]) {
                    out.ans("CONTINUE").ln();
                    return;
                }
            }
        }
        out.ans("GAMEOVER").ln();
    }
}
