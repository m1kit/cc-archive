package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;
import dev.mikit.atcoder.lib.structure.IntMultiSet;

public class EPickingGoods {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int r = in.ints(), c = in.ints(), k = in.ints();
        long[][] v = new long[r][c];
        long[][][] dp = new long[4][r + 1][c + 1];
        for (int i = 0; i < k; i++) v[in.ints() - 1][in.ints() - 1] = in.longs();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int p = 0; p <= 3; p++) {
                    // come up
                    dp[0][i + 1][j + 1] = Math.max(dp[0][i + 1][j + 1], dp[p][i][j + 1]);
                    // come up and pick
                    dp[1][i + 1][j + 1] = Math.max(dp[1][i + 1][j + 1], dp[p][i][j + 1] + v[i][j]);
                    // come right
                    dp[p][i + 1][j + 1] = Math.max(dp[p][i + 1][j + 1], dp[p][i + 1][j]);
                    if (p == 3) continue;
                    // come right and pick
                    dp[p + 1][i + 1][j + 1] = Math.max(dp[p + 1][i + 1][j + 1], dp[p][i + 1][j] + v[i][j]);
                }
            }
        }
        out.ans(IntMath.max(dp[0][r][c], dp[1][r][c], dp[2][r][c], dp[3][r][c])).ln();
    }
}
