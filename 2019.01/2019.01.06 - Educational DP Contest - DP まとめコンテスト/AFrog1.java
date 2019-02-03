package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

import java.util.Arrays;

public class AFrog1 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] h = new long[n + 1];
        for (int i = 0; i < n; i++) {
            h[i] = in.ints();
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1_000_000_000_000_000L);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + Math.abs(h[i] - h[i + 1]));
            dp[i + 2] = Math.min(dp[i + 2], dp[i] + Math.abs(h[i] - h[i + 2]));
        }
        out.ans(dp[n - 1]).ln();
    }
}
