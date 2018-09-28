package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] lastIndex = new int[m + 1];
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            int f = in.nextInt();
            k = Math.max(k, lastIndex[f]);
            lastIndex[f] = i;
            for (int j = k; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] %= 1000000007;
        }
        out.println(dp[n]);
    }
}
