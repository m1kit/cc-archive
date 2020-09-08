package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class DMixingExperiment {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ma = in.ints(), mb = in.ints();
        Drug[] drugs = new Drug[n];
        for (int i = 0; i < n; i++) {
            drugs[i] = new Drug(in.ints(), in.ints(), in.ints());
        }

        int[][][] dp = new int[n + 1][401][401];
        ArrayUtil.fill(dp, 4001);
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 400; j++) {
                for (int k = 0; k <= 400; k++) {
                    dp[i + 1][j][k] = dp[i][j][k];
                    if (j - drugs[i].a < 0 || k - drugs[i].b < 0) continue;
                    dp[i + 1][j][k] = Math.min(dp[i + 1][j][k], dp[i][j - drugs[i].a][k - drugs[i].b] + drugs[i].c);
                }
            }
        }

        int ans = 4001;
        for (int i = 1; i * ma <= 400 && i * mb <= 400; i++) {
            ans = Math.min(ans, dp[n][i * ma][i * mb]);
        }
        out.ansln(ans > 4000 ? -1 : ans);
    }

    private static class Drug {
        int a, b, c;

        public Drug(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
