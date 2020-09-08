package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DLamp {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        String[] s = in.string(h);

        int[][] l = new int[h][w + 1], r = new int[h][w + 1];
        int[][] u = new int[h + 1][w], d = new int[h + 1][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                l[i][j + 1] = s[i].charAt(j) == '#' ? 0 : l[i][j] + 1;
            }
            for (int j = w - 1; j >= 0; j--) {
                r[i][j] = s[i].charAt(j) == '#' ? 0 : r[i][j + 1] + 1;
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                d[j + 1][i] = s[j].charAt(i) == '#' ? 0 : d[j][i] + 1;
            }
            for (int j = h - 1; j >= 0; j--) {
                u[j][i] = s[j].charAt(i) == '#' ? 0 : u[j + 1][i] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i].charAt(j) == '#') continue;
                max = Math.max(max, l[i][j + 1] + r[i][j] + d[i + 1][j] + u[i][j] - 3);
            }
        }
        out.ans(max).ln();
    }
}
