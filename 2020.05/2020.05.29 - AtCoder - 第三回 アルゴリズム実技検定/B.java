package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), q = in.ints();
        boolean[][] solved = new boolean[n][m];
        int[] score = new int[m];
        Arrays.fill(score, n);
        for (int i = 0; i < q; i++) {
            if (in.ints() == 1) {
                int ans = 0, x = in.ints() - 1;
                for (int j = 0; j < m; j++) {
                    if (solved[x][j]) ans += score[j];
                }
                out.ans(ans).ln();
            } else {
                int x = in.ints() - 1, y = in.ints() - 1;
                solved[x][y] = true;
                score[y]--;
            }
        }
    }
}
