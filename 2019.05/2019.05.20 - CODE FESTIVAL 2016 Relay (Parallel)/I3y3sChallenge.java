package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class I3y3sChallenge {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (n == 2) {
            out.ans(-1).ln();
            return;
        }
        int[][] ans = new int[n][n - 1];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    ans[i][j] = n;
                } else {
                    ans[i][j] = j + 1;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            ans[n - 1][i] = (i + 1) % (n - 1) + 1;
        }
        for (int i = 0; i < n; i++) {
            out.ans(ans[i]).ln();
        }
    }
}
