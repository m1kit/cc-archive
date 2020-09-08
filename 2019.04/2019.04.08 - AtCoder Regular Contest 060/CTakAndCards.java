package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTakAndCards {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), x = in.ints();
        int[] a = in.ints(n);

        long[][][] dp = new long[n + 1][n + 1][2501];
        dp[0][0][0] = 1;
        // i枚目までみてj枚使い合計がk
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= 2500; i++) {
                for (int k = 0; k < n; k++) {
                    dp[j + 1][k][i] = dp[j][k][i];
                }
            }
            for (int k = 0; k <= 2500 - a[j]; k++) {
                for (int i = 0; i < n; i++) {
                    dp[j + 1][i + 1][k + a[j]] += dp[j][i][k];
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += dp[n][i][i * x];
        }
        out.ansln(ans);
    }
}
