package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Comparator;

public class EActiveInfants {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        T[] a = new T[n];
        for (int i = 0; i < n; i++) a[i] = new T(i, in.longs());
        IntroSort.sort(a, Comparator.comparing(t -> -t.x));
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + Math.abs(n - 1 - i + j - a[i].i) * a[i].x);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + Math.abs(j - a[i].i) * a[i].x);
            }
        }
        out.ans(IntMath.max(dp[n])).ln();
    }

    private static class T {
        int i;
        long x;

        T(int i, long x) {
            this.i = i;
            this.x = x;
        }
    }
}
