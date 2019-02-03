package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.IntMath;

public class DKnapsack1 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] w = new int[n], v = new int[n];
        in.ints(w, v);
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (m >= w[i] + j) {
                    dp[i + 1][w[i] + j] = Math.max(dp[i + 1][w[i] + j], dp[i][j] + v[i]);
                }
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        out.ans(IntMath.max(dp[n])).ln();
    }
}
