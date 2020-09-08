package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BServalAndToyBricks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), h = in.ints();
        int[] front = in.ints(m), left = in.ints(n);
        int[][] top = in.ints(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (top[i][j] == 0) {
                    out.ans(0);
                    continue;
                }
                out.ans(Math.min(front[j], left[i]));
            }
            out.ln();
        }
    }
}
