package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.IntMath;

public class CVacation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = new int[n], b = new int[n], c = new int[n];
        in.ints(a, b, c);
        long[][] dp = new long[3][n + 1];
        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = Math.max(dp[1][i] + a[i], dp[2][i] + a[i]);
            dp[1][i + 1] = Math.max(dp[0][i] + b[i], dp[2][i] + b[i]);
            dp[2][i + 1] = Math.max(dp[1][i] + c[i], dp[0][i] + c[i]);
        }
        out.ans(IntMath.max(dp[0][n], dp[1][n], dp[2][n])).ln();

    }
}
