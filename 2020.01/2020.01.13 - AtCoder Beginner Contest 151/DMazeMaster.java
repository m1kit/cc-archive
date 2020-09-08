package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class DMazeMaster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints(), n = h * w;
        char[][] s = in.chars(h);
        long[][] d = new long[n][n];
        ArrayUtil.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i < h - 1; i++)
            for (int j = 0; j < w; j++)
                d[i * w + j][(i + 1) * w + j] = d[(i + 1) * w + j][i * w + j] = 1;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w - 1; j++)
                d[i * w + j][i * w + j + 1] = d[i * w + j + 1][i * w + j] = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j] != '#') continue;
                for (int k = 0; k < n; k++) {
                    d[i * w + j][k] = d[k][i * w + j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) d[i][i] = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] < Integer.MAX_VALUE) ans = Math.max(ans, d[i][j]);
            }
        }
        out.ans(ans).ln();
    }
}
