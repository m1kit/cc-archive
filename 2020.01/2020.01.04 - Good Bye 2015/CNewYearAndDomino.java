package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CNewYearAndDomino {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints();
        char[][] b = new char[h][];
        for (int i = 0; i < h; i++) b[i] = in.string().toCharArray();
        int[][] cs = new int[h + 1][w + 1], rs = new int[h + 1][w + 1];
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cs[i + 1][j + 1] = cs[i + 1][j] + cs[i][j + 1] - cs[i][j];
                if (b[i][j] == '.' && b[i - 1][j] == '.') cs[i + 1][j + 1]++;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                rs[i + 1][j + 1] = rs[i + 1][j] + rs[i][j + 1] - rs[i][j];
                if (b[i][j] == '.' && b[i][j - 1] == '.') rs[i + 1][j + 1]++;
            }
        }

        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int y1 = in.ints(), x1 = in.ints();
            int y2 = in.ints(), x2 = in.ints();
            out.ans(
                    cs[y2][x2] - cs[y1][x2]
                            - cs[y2][x1 - 1] + cs[y1][x1 - 1]
                            + rs[y2][x2] - rs[y1 - 1][x2]
                            - rs[y2][x1] + rs[y1 - 1][x1]
            ).ln();
        }
    }
}
