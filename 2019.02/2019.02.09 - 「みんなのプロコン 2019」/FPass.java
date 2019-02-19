package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class FPass {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        String s = in.string();
        int n = s.length(), n2 = n * 2;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (s.charAt(i) - '0');
        }

        long[][] dp = new long[n2 + 1][n2 + 1];
        dp[0][0] = 1;
        // 青の個数, ターン, 人
        for (int i = 0; i < n2; i++) {
            // i + 1 回使った
            int bl = sum[Math.min(i + 1, n)];
            int re = (i + 1) * 2 - bl;

            // 赤を出す
            for (int j = Math.max(0, i + 1 - bl); j <= Math.min(re, i + 1); j++) {
                // j個
                dp[i + 1][i + 1 - j] += dp[i][i + 1 - j];
                dp[i + 1][i + 1 - j] %= MOD;
            }

            //　青を出す
            for (int j = Math.max(1, i + 1 - re); j <= Math.min(bl, i + 1); j++) {
                // j個今までに使う
                dp[i + 1][j] += dp[i][j - 1];
                dp[i + 1][j] %= MOD;
            }
        }
        //Debug.debug(dp);
        out.ans(dp[n2][sum[n]]).ln();
    }


}
