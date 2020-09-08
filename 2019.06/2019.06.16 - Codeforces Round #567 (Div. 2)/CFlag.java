package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CFlag {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        String[] s = in.string(h);

        int[][] length = new int[h][w];
        for (int i = 0; i < h; i++) {
            length[i][w - 1] = 1;
            for (int j = w - 2; j >= 0; j--) {
                if (s[i].charAt(j) == s[i].charAt(j + 1)) {
                    length[i][j] = length[i][j + 1] + 1;
                } else {
                    length[i][j] = 1;
                }
            }
        }
        int[][] up = new int[h][w], down = new int[h][w];
        for (int i = 0; i < w; i++) {
            up[0][i] = 1;
            down[h - 1][i] = 1;
            for (int j = 1; j < h; j++) {
                if (s[j].charAt(i) == s[j - 1].charAt(i)) {
                    up[j][i] = up[j - 1][i] + 1;
                } else {
                    up[j][i] = 1;
                }
            }
            for (int j = h - 2; j >= 0; j--) {
                if (s[j].charAt(i) == s[j + 1].charAt(i)) {
                    down[j][i] = down[j + 1][i] + 1;
                } else {
                    down[j][i] = 1;
                }
            }
        }

        //Arrays.stream(down).map(Arrays::toString).forEach(System.out::println);

        long ans = 0;
        for (int i = 1; i < h; i++) {
            mid: for (int j = 0; j < w; j++) {
                // 中央の左上
                if (s[i].charAt(j) == s[i - 1].charAt(j)) continue;
                int d = down[i][j];
                if (i + d + d - 1 >= h || i - d < 0) continue;
                if (down[i - d][j] != d || up[i + d + d - 1][j] != d) continue;
                int width = Integer.MAX_VALUE;
                for (int k = i - d; k < i + d + d; k++) {
                    width = Math.min(width, length[k][j]);
                }
                //System.out.println("("+j+", " + i + ") = " + width + " d="+d);
                ans += width;
            }
        }
        out.ans(ans).ln();
    }
}
