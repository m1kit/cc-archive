package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class D {

    private static final int MOD = (int) 1e9 + 7;
    private static final int[] DX = {1, 1, 1, 0, -1, -1, -1, 0, 0};
    private static final int[] DY = {1, 0, -1, -1, -1, 0, 1, 1, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_ALL_DOWN);
        int h = in.ints(), w = in.ints();
        char[][] s = new char[h][];
        for (int i = 0; i < h; i++) s[i] = in.string().toCharArray();
        char[][] t = new char[h][w];
        ArrayUtil.fill(t, '.');
        for (int i = 0; i < h; i++) {
            loop: for (int j = 0; j < w; j++) {
                for (int k = 0; k < 9; k++) {
                    int nx = j + DX[k], ny = i + DY[k];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                    if (s[ny][nx] == '.') continue loop;
                }
                t[i][j] = '#';
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean black = false;
                for (int k = 0; k < 9; k++) {
                    int nx = j + DX[k], ny = i + DY[k];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                    if (t[ny][nx] == '#') {
                        black = true;
                        break;
                    }
                }
                if ((s[i][j] == '#') != black) {
                    out.noln();
                    return;
                }
            }
        }
        out.yesln();
        for (int i = 0; i < h; i++) {
            out.ans(String.valueOf(t[i])).ln();
        }
    }
}
