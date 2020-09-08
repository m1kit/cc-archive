package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.structure.IntMultiSet;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class CMonsterInvaders {

    private static final long INF = (long) 2e18;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long r1 = in.longs(), r2 = in.longs(), r3 = in.longs(), d = in.longs();
        long[] a = in.longs(n);
        //long x = a[n - 1];
        //long c1 = x * r1 + r3, c2 = IntMath.min(c1, (x + 2) * r1, r1 + r2);
        out.ans(calc(n, r1, r2, r3, d, a) + d * (n - 1L)).ln();
    }

    private static long calc(int n, long r1, long r2, long r3, long d, long[] a) {
        long[][] dp = new long[3][n + 1];
        ArrayUtil.fill(dp, INF);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            long c1 = a[i] * r1 + r3;
            dp[0][i + 1] = Math.min(dp[0][i + 1], dp[0][i] + c1);
            dp[0][i + 1] = Math.min(dp[0][i + 1], dp[1][i] + c1); // free
            if (i != n - 1) {
                dp[1][i + 1] = Math.min(dp[1][i + 1], dp[1][i] + c1 + 2 * d);
                dp[1][i + 1] = Math.min(dp[1][i + 1], dp[0][i] + c1 + 2 * d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[0][i] + c1 + d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[1][i] + c1 + d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[2][i] + c1 + d);
            } else {
                // dp[2][i + 1] = Math.min(dp[2][i + 1], dp[0][i] + c1);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[2][i] + c1);
            }

            long c2 = Math.min((a[i] + 2L) * r1, r1 + r2);
            //dp[0][i + 1] = Math.min(dp[0][i + 1], dp[0][i]);
            dp[0][i + 1] = Math.min(dp[0][i + 1], dp[1][i] + c2); // free
            if (i != n - 1) {
                dp[1][i + 1] = Math.min(dp[1][i + 1], dp[1][i] + c2 + 2 * d);
                dp[1][i + 1] = Math.min(dp[1][i + 1], dp[0][i] + c2 + 2 * d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[0][i] + c2 + d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[1][i] + c2 + d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[2][i] + c2 + d);
            } else {
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[0][i] + c2 + 2 * d);
                dp[2][i + 1] = Math.min(dp[2][i + 1], dp[2][i] + c2 + 2 * d);
            }
        }
        //System.out.println(Arrays.toString(dp[0]));
        //System.out.println(Arrays.toString(dp[1]));
        //System.out.println(Arrays.toString(dp[2]));
        return IntMath.min(dp[0][n], dp[1][n], dp[2][n]);
    }
}
