package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

import java.util.Arrays;

public class BFrog2 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        long[] h = new long[n + k];
        for (int i = 0; i < n; i++) {
            h[i] = in.ints();
        }
        long[] dp = new long[n + k];
        Arrays.fill(dp, 1_000_000_000_000_000L);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(h[i] - h[i + j]));
            }
        }
        out.ans(dp[n - 1]).ln();
    }
}
