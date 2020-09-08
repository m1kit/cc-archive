package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class IProcurement {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] s = new int[m];
        long[] c = new long[m];
        for (int i = 0; i < m; i++) {
            char[] t = in.string().toCharArray();
            for (int j = 0; j < n; j++) {
                if (t[j] == 'Y') s[i] |= 1 << j;
            }
            c[i] = in.longs();
        }
        long[][] dp = new long[m + 1][1 << n];
        Arrays.fill(dp[0], 1_000_000_000_000_000L);
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(dp[i], 0, dp[i + 1], 0, 1 << n);
            for (int j = 0; j < (1 << n); j++) {
                dp[i + 1][j | s[i]] = Math.min(dp[i + 1][j | s[i]], dp[i][j] + c[i]);
            }
        }
        long ans = dp[m][(1 << n) - 1];
        if (ans > 1e12) out.ans(-1).ln();
        else out.ans(ans).ln();
    }
}
