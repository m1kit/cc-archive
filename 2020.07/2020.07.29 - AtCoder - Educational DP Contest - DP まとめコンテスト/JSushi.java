package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class JSushi {

    private static int n;
    private static double[][][] dp;


    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        int[] c = new int[4];
        dp = new double[n + 1][n + 1][n + 1];
        ArrayUtil.fill(dp, Double.NaN);
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) c[in.ints()]++;
        out.ans(dp(c[1], c[2], c[3]), 15).ln();
    }

    private static double dp(int c1, int c2, int c3) {
        if (!Double.isNaN(dp[c1][c2][c3])) return dp[c1][c2][c3];
        double sum = c1 + c2 + c3;
        double ans = n / sum;
        if (c1 > 0) ans += c1 / sum * dp(c1 - 1, c2, c3);
        if (c2 > 0) ans += c2 / sum * dp(c1 + 1, c2 - 1, c3);
        if (c3 > 0) ans += c3 / sum * dp(c1, c2 + 1, c3 - 1);
        //System.out.println(n + "/" + c1 + "," + c2 + "," + c3 + ":" + ans);
        return dp[c1][c2][c3] = ans;
    }
}
