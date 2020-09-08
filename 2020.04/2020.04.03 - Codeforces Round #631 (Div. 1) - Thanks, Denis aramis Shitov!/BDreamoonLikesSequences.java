package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.Arrays;

public class BDreamoonLikesSequences {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int d = in.ints(), m = in.ints(), n = BitMath.msb(d) + 1, p = d - (1 << (n - 1)) + 1;
            long[][] dp = new long[n + 1][n + 1];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) { // before
                    for (int k = j + 1; k < n; k++) { // after
                        dp[i + 1][k] += dp[i][j] << (k - 1);
                        dp[i + 1][k] %= m;
                    }
                    dp[i + 1][n] += dp[i][j] * p;
                    dp[i + 1][n] %= m;
                }
            }
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans += dp[i][j];
                }
            }
            out.ans(ans % m).ln();
            //System.out.printf("d=%d i=%d j=%d\n", d, i, j);
            //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        }
    }
}
