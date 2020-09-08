package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.Arrays;

public class ETheContest {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), c = in.ints(), n = a + b + c;
        int[] p = new int[n];
        for (int i = 0; i < a; i++) p[in.ints() - 1] = 0;
        for (int i = 0; i < b; i++) p[in.ints() - 1] = 1;
        for (int i = 0; i < c; i++) p[in.ints() - 1] = 2;
        int[][] dp = new int[3][n + 1];
        for (int i = 0; i < 3; i++) Arrays.fill(dp[i], n);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int from = 0; from < 3; from++) {
                for (int to = from; to < 3; to++) {
                    dp[to][i + 1] = Math.min(dp[to][i + 1], dp[from][i] + (p[i] == to ? 0 : 1));
                }
            }
        }
        out.ans(IntMath.min(dp[0][n], dp[1][n], dp[2][n])).ln();
    }
}
