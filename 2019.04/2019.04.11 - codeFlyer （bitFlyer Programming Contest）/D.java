package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int height = in.ints(), width = in.ints();
        int n = in.ints(), m = in.ints();
        String[] a = in.string(n);
        int h = Math.min(height, 2 * n + 1), w = Math.min(width, 2 * m + 1);
        long[][] weight = new long[h][w];
        ArrayUtil.fill(weight, 1);
        if (height > 2 * n) {
            for (int i = 0; i < w; i++) {
                weight[n][i] *= height - 2 * n;
            }
        }
        if (width > 2 * m) {
            for (int i = 0; i < h; i++) {
                weight[i][m] *= width - 2 * m;
            }
        }

        int[][] cnt = new int[h + 1][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i].charAt(j) == '#') {
                    cnt[i][j]++;
                    cnt[h - n + i + 1][w - m + j + 1]++;
                    cnt[i][w - m + j + 1]--;
                    cnt[h - n + i + 1][j]--;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cnt[i + 1][j] += cnt[i][j];
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cnt[i][j + 1] += cnt[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (cnt[i][j] > 0) {
                    ans += weight[i][j];
                }
            }
        }
        out.ans(ans).ln();
    }
}
