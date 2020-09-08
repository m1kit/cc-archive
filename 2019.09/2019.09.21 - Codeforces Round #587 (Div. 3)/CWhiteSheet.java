package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.Arrays;

public class CWhiteSheet {

    private static int[][] x, y;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        x = new int[2][3];
        y = new int[2][3];
        in.ints(x[0], y[0], x[1], y[1]);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] *= 2;
                y[i][j] *= 2;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = -3; k <= 3; k++) {
                    for (int l = -3; l <=3; l++) {
                        int r = x[i % 2][i / 2] + k;
                        int c = y[j % 2][j / 2] + l;
                        if (sat(r, c)) {
                            out.yesln();
                            return;
                        }
                    }
                }
            }
        }
        out.noln();
    }

    private static boolean sat(int r, int c) {
        if (r < x[0][0] || x[1][0] < r || c < y[0][0] || y[1][0] < c) return false;
        for (int j = 1; j < 3; j++) {
            if (x[0][j] <= r && r <= x[1][j] && y[0][j] <= c && c <= y[1][j]) {
                return false;
            }
        }
        return true;
    }
}
