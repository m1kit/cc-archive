package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BPCAS {

    private static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] DY = {1, 1, 0, -1, -1, -1, 0, 1};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int x = in.ints() - 1, y = in.ints() - 1;
        int d = -1;
        {
            String s = in.string();
            if ("R".equals(s)) d = 2;
            else if ("L".equals(s)) d = 6;
            else if ("U".equals(s)) d = 4;
            else if ("D".equals(s)) d = 0;
            else if ("RU".equals(s)) d = 3;
            else if ("RD".equals(s)) d = 1;
            else if ("LU".equals(s)) d = 5;
            else if ("LD".equals(s)) d = 7;
        }
        char[][] s = new char[9][];
        for (int i = 0; i < 9; i++) s[i] = in.string().toCharArray();

        for (int i = 0; i < 4; i++) {
            out.print(s[y][x]);
            int nx = x + DX[d], ny = y + DY[d];
            if (nx < 0) {
                DX[d] *= -1;
                nx = 1;
            }
            if (ny < 0) {
                DY[d] *= -1;
                ny = 1;
            }
            if (9 <= nx) {
                DX[d] *= -1;
                nx = 7;
            }
            if (9 <= ny) {
                DY[d] *= -1;
                ny = 7;
            }
            x = nx;
            y = ny;
        }
        out.ln();
    }
}
