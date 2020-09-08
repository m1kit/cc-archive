package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Stack;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        // i文字目までをj文字目までの編集でdepthをkにするコスト
        ArrayUtil.fill(dp, 1000);
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // 編集しない
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k < n; k++) {
                        dp[i + 1][j][k + 1] = Math.min(dp[i + 1][j][k + 1], dp[i][j][k]);
                    }
                }
                // 編集する
                for (int j = 0; j <= i; j++) {
                    for (int k = 1; k <= n; k++) {
                        dp[i + 1][i + 1][k - 1] = Math.min(dp[i + 1][i + 1][k - 1], dp[i][j][k] + 1);
                    }
                }
            } else {
                // 編集しない
                for (int j = 0; j <= i; j++) {
                    for (int k = 1; k <= n; k++) {
                        dp[i + 1][j][k - 1] = Math.min(dp[i + 1][j][k - 1], dp[i][j][k]);
                    }
                }
                // 編集する
                for (int j = 0; j <= i; j++) {
                    for (int k = 0; k < n; k++) {
                        dp[i + 1][i + 1][k + 1] = Math.min(dp[i + 1][i + 1][k + 1], dp[i][j][k] + 1);
                    }
                }
            }
        }
        int ans = 1000;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, dp[n][i][0] + Math.max(0, i - 1));
        }
        out.ansln(ans);
    }
}
