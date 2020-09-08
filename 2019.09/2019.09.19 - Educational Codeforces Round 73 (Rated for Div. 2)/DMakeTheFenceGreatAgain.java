package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.stream.Stream;

public class DMakeTheFenceGreatAgain {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long[] a = new long[n], b = new long[n];
            in.longs(a, b);
            long[][] dp = new long[3][n];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(dp[i], 1_000_000_000_000_000_000L);
                dp[i][0] = b[0] * i;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (a[i - 1] + j != a[i] + k) dp[k][i] = Math.min(dp[k][i], dp[j][i - 1] + b[i] * k);
                    }
                }
            }
            //Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
            out.ans(IntMath.min(dp[0][n - 1], dp[1][n - 1], dp[2][n - 1])).ln();
        }
    }
}
