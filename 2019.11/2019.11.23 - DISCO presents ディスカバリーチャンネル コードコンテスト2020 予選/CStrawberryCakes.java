package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CStrawberryCakes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints(), k = in.ints();
        char[][] s = new char[h][];
        int min = h;
        for (int i = 0; i < h; i++) {
            s[i] = in.string().toCharArray();
            for (int j = 0; j < w; j++) {
                if (s[i][j] == '#') min = Math.min(min, i);
            }
        }
        int[][] ans = new int[h][w];
        int cur = 0;
        for (int i = min; i < h; i++) {
            int last = -1;
            for (int j = w - 1; j >= 0; j--) {
                if (s[i][j] == '#') {
                    if (last == -1) last = j;
                    ans[i][j] = ++cur;
                } else if (j < w - 1) {
                    ans[i][j] = cur;
                }
            }
            if (last == -1) {
                System.arraycopy(ans[i - 1], 0, ans[i], 0, w);
            } else {
                for (int j = w - 1; j > last; j--) ans[i][j] = ans[i][last];
            }
        }
        for (int i = min - 1; i >= 0; i--) {
            System.arraycopy(ans[i + 1], 0, ans[i], 0, w);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out.ans(ans[i][j]);
            }
            out.ln();
        }
    }
}
