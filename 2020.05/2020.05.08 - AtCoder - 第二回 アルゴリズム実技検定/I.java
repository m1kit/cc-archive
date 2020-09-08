package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class I {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = 1 << n;
        int[] dp = new int[2 * m - 1];
        for (int i = m - 1; i < 2 * m - 1; i++) dp[i] = in.ints();
        for (int i = m - 2; i >= 0; i--) dp[i] = Math.max(dp[i * 2 + 1], dp[i * 2 + 2]);
        for (int i = 0; i < m; i++) {
            int now = m - 1 + i, ans = 1;
            while (2 < now) {
                int next = (now - 1) / 2;
                if (dp[now] != dp[next]) break;
                ans++;
                now = next;
            }
            out.ans(ans).ln();
        }
        //System.out.println(Arrays.toString(dp));
    }
}
