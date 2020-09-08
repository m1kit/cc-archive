package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class AConnectionAndDisconnection {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        int n = s.length;
        long k = in.longs();

        if (n == 1) {
            out.ans(k / 2).ln();
            return;
        }

        long[][] dp1 = new long[2][n];
        dp1[1][0] = 1;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] == s[i]) {
                dp1[0][i] = dp1[1][i - 1];
            } else {
                dp1[0][i] = Math.min(dp1[0][i - 1], dp1[1][i - 1]);
            }
            dp1[1][i] = Math.min(dp1[0][i - 1], dp1[1][i - 1]) + 1;
        }

        long[][] dp2 = new long[2][n];
        dp2[0][0] = Integer.MAX_VALUE;
        dp2[1][0] = 1;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] == s[i]) {
                dp2[0][i] = dp2[1][i - 1];
            } else {
                dp2[0][i] = Math.min(dp2[0][i - 1], dp2[1][i - 1]);
            }
            dp2[1][i] = Math.min(dp2[0][i - 1], dp2[1][i - 1]) + 1;
        }

        long base = Math.min(dp1[0][n - 1], dp1[1][n - 1]);
        if (s[0] != s[n - 1]) {
            out.ans(base * k).ln();
        } else {
            long a = base + Math.min(dp2[0][n - 1], dp2[1][n - 1]) * (k - 1L);
            long b = base + dp1[1][n - 1] * (k - 1L);
            long c = ((k + 1) / 2) * base + dp2[1][n - 1] * (k / 2);
            out.ans(IntMath.min(a, b, c)).ln();
        }
    }
}
