package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class AGarland {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        boolean[] ok = new boolean[n];
        int[] a = in.ints(n);
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) continue;
            ok[a[i] - 1] = true;
        }
        int evens = 0, odds = 0;
        for (int i = 0; i < n; i++) {
            if (ok[i]) continue;
            if (i % 2 == 0) odds++;
            else evens++;
        }
        int[][][][] dp = new int[2][n + 1][n + 1][n + 1];
        ArrayUtil.fill(dp[0], 2 * n);
        ArrayUtil.fill(dp[1], 2 * n);
        dp[0][0][0][0] = dp[1][0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                // Use even
                for (int odd = 0; odd <= n; odd++)
                    for (int even = 0; even <= n - 1; even++)
                        dp[0][i + 1][even + 1][odd] = IntMath.min(dp[0][i + 1][even + 1][odd], dp[0][i][even][odd], dp[1][i][even][odd] + 1);
                // Use odd
                for (int odd = 0; odd <= n - 1; odd++)
                    for (int even = 0; even <= n; even++)
                        dp[1][i + 1][even][odd + 1] = IntMath.min(dp[1][i + 1][even][odd + 1], dp[0][i][even][odd] + 1, dp[1][i][even][odd]);
            } else {
                for (int odd = 0; odd <= n; odd++) {
                    for (int even = 0; even <= n; even++) {
                        dp[a[i] % 2][i + 1][even][odd] = Math.min(dp[a[i] % 2][i][even][odd], dp[1 - (a[i] % 2)][i][even][odd] + 1);
                    }
                }
            }
        }
        //System.out.println("e=" + evens + " o=" + odds);
        out.ans(Math.min(dp[0][n][evens][odds], dp[1][n][evens][odds])).ln();
    }
}
