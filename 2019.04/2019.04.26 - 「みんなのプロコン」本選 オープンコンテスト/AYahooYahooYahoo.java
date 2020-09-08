package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class AYahooYahooYahoo {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        int[][] dp = new int[5][n + 1];
        ArrayUtil.fill(dp, n);
        dp[0][0] = 0; /* 0 y 1 a 2 h 3 o 4 o 0 */
        String yahoo = "yahoo";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[j][i + 1] = Math.min(dp[j][i + 1], dp[j][i] + 1); // deletion
                int delta = s.charAt(i) == yahoo.charAt((j + 4) % 5) ? 0 : 1;
                dp[j][i + 1] = Math.min(dp[j][i + 1], dp[(j + 4) % 5][i] + delta); // modify
                for (int k = 1; k < 5; k++) {
                    dp[j][i + 1] = Math.min(dp[j][i + 1], dp[(5 + j - 1 - k) % 5][i] + k + delta); // insertion
                }
            }
        }
        //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        out.ans(dp[0][n]).ln();
    }
}
