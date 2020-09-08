package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BFillingTheGrid {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        int[] r = in.ints(h), c = in.ints(w);
        int[][] state = new int[h][w];
        ArrayUtil.fill(state, -1);
        long ans = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r[i]; j++) {
                state[i][j] = 1;
            }
            if (r[i] < w) state[i][r[i]] = 0;
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < c[i]; j++) {
                if (state[j][i] == 0) ans = 0;
                else state[j][i] = 1;
            }
            if (c[i] < h) {
                if (state[c[i]][i] == 1) ans = 0;
                else state[c[i]][i] = 0;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (state[i][j] == -1) {
                    ans *= 2;
                    ans %= MOD;
                }
            }
        }
        out.ans(ans).ln();
    }
}
