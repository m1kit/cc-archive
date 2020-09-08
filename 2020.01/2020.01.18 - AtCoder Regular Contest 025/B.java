package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints();
        int[][][] c = new int[2][h + 1][w + 1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                c[0][i + 1][j + 1] = c[0][i][j + 1] + c[0][i + 1][j] - c[0][i][j];
                c[1][i + 1][j + 1] = c[1][i][j + 1] + c[1][i + 1][j] - c[1][i][j];
                c[(i + j) % 2][i + 1][j + 1] += in.ints();
            }
        }
        int ans = 0;
        for (int y0 = 0; y0 < h; y0++) {
            for (int y1 = y0 + 1; y1 <= h; y1++) {
                for (int x0 = 0; x0 < w; x0++) {
                    for (int x1 = x0 + 1; x1 <= w; x1++) {
                        if (c[0][y1][x1] - c[0][y1][x0] - c[0][y0][x1] + c[0][y0][x0]
                                == c[1][y1][x1] - c[1][y1][x0] - c[1][y0][x1] + c[1][y0][x0])
                            ans = Math.max(ans, (y1 - y0) * (x1 - x0));
                    }
                }
            }
        }
        out.ans(ans).ln();
    }
}
