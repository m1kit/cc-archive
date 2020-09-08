package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class DSwapAndFlip {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = 1 << n;
        int[][] a = in.ints(2, n);
        for (int i = 1; i < n; i += 2) {
            int t = a[0][i];
            a[0][i] = a[1][i];
            a[1][i] = t;
        }

        int[][] dp = new int[51][m];
        ArrayUtil.fill(dp, 1_000_000);
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            int p = Integer.bitCount(i) % 2;
            for (int j = 0; j < n; j++) {
                int bit = 1 << j;
                if ((i & bit) != 0) continue;
                for (int k = 0; k <= a[p][j]; k++) {
                    dp[a[p][j]][i | bit] = Math.min(dp[a[p][j]][i | bit], dp[k][i] + Integer.bitCount(i >> j));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 50; i++) {
            ans = Math.min(ans, dp[i][m - 1]);
        }
        out.ans(ans >= 1_000_000 ? -1 : ans).ln();
    }
}
