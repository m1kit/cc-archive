package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class K {

    private static final int MAX = 1500;
    private static final long INF = (long) 1e15;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[] s = in.chars();
        int[] a = in.ints(n), b = in.ints(n);
        long[][] dp = new long[MAX + 1][n + 1];
        ArrayUtil.fill(dp, INF);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= MAX; j++) dp[j][i + 1] = dp[j][i] + b[i];
            int c0 = s[i] == '(' ? 0 : a[i], c1 = s[i] == ')' ? 0 : a[i];
            for (int j = 0; j < MAX; j++) dp[j + 1][i + 1] = Math.min(dp[j + 1][i + 1], dp[j][i] + c0);
            for (int j = 1; j <= MAX; j++) dp[j - 1][i + 1] = Math.min(dp[j - 1][i + 1], dp[j][i] + c1);
        }
        out.ans(dp[0][n]).ln();
    }
}
