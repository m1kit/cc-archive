package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class Round1B2019GoogleCodeJam2019 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int p = in.ints(), q = in.ints();
        int[][] cnt = new int[4][q + 1];
        for (int i = 0; i < p; i++) {
            int x = in.ints(), y = in.ints();
            char c = in.string().charAt(0);
            switch (c) {
                case 'E': cnt[0][x]++; break;
                case 'N': cnt[1][y]++; break;
                case 'W': cnt[2][x]++; break;
                case 'S': cnt[3][y]++; break;
            }
        }
        int[][] sum = new int[4][q + 2];
        for (int i = 0; i <= q; i++) {
            sum[0][i + 1] = sum[0][i] + cnt[0][i];
            sum[1][i + 1] = sum[1][i] + cnt[1][i];
        }
        for (int i = q; i >= 0; i--) {
            sum[2][i] = sum[2][i + 1] + cnt[2][i];
            sum[3][i] = sum[3][i + 1] + cnt[3][i];
        }

        int x = -1, xmax = -1, y = -1, ymax = -1;
        for (int i = 0; i <= q; i++) {
            int nx = sum[0][i] + sum[2][i + 1], ny = sum[1][i] + sum[3][i + 1];
            if (nx > xmax) {
                xmax = nx;
                x = i;
            }
            if (ny > ymax) {
                ymax = ny;
                y = i;
            }
        }
        out.ans("Case #" + testNumber + ":").ans(x).ans(y).ln();
    }
}
