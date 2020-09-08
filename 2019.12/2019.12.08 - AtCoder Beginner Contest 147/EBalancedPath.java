package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EBalancedPath {

    private static final int MAX = 10000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        int[][] a = in.ints(h, w), b = in.ints(h, w);
        boolean[][][] ok = new boolean[h + 1][w + 1][MAX];
        ok[0][1][0] = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int d = Math.abs(a[i][j] - b[i][j]);
                for (int k = 0; k < MAX; k++) {
                    ok[i + 1][j + 1][Math.abs(k - d)] |= ok[i + 1][j][k];
                    ok[i + 1][j + 1][Math.abs(k - d)] |= ok[i][j + 1][k];
                }
                for (int k = 0; k < MAX - d; k++) {
                    ok[i + 1][j + 1][k + d] |= ok[i + 1][j][k];
                    ok[i + 1][j + 1][k + d] |= ok[i][j + 1][k];
                }
            }
        }
        for (int i = 0; i < MAX; i++) {
            if (ok[h][w][i]) {
                out.ans(i).ln();
                return;
            }
        }
        throw new RuntimeException();
    }
}
