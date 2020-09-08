package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        long[] dp = new long[500001];
        for (int i = 1; i <= 500000; i++) dp[i] = dp[i - 1] + i;
        int n = s.length;

        int start = 0;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] != '>' || s[i] != '<') continue;
            int left = 0, right = 0;
            for (int j = start; j < i; j++) {
                if (s[j] == '<') left++;
                else right++;
            }
            if (left > right) {
                ans += dp[left] + dp[Math.max(0, right - 1)];
            } else {
                ans += dp[Math.max(0, left - 1)] + dp[right];
            }
            start = i;
        }

        int left = 0, right = 0;
        for (int i = start; i < n; i++) {
            if (s[i] == '<') left++;
            else right++;
        }
        if (left > right) {
            ans += dp[left] + dp[Math.max(0, right - 1)];
        } else {
            ans += dp[Math.max(0, left - 1)] + dp[right];
        }
        out.ans(ans).ln();
    }
}
