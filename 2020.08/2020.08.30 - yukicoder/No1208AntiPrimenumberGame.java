package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class No1208AntiPrimenumberGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        out.setBoolLabel(LightWriter2.BoolLabel.FIRST_SECOND_FIRST_UP);
        int n = in.ints();
        long m = in.longs();
        long[] a = in.longs(n);
        long[][] dp = new long[2][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 1) {
                dp[0][i] = dp[1][i + 1] + (1 - m);
                dp[1][i] = dp[0][i + 1] - (1 - m);
            } else {
                dp[0][i] = Math.max(dp[0][i + 1] + (a[i] + m - 2), dp[1][i + 1] + (a[i] - m));
                dp[1][i] = Math.min(dp[1][i + 1] - (a[i] + m - 2), dp[0][i + 1] - (a[i] - m));
            }
        }
        out.ans(dp[0][0] > 0).ln();
    }
}
