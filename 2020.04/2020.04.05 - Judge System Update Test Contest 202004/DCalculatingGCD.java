package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.Arrays;

public class DCalculatingGCD {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        long[] a = in.longs(n);
        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) sum[i + 1] = IntMath.gcd(sum[i], a[i]);

        for (int i = 0; i < q; i++) {
            long x = in.longs();
            if (IntMath.gcd(x, sum[n]) > 1) {
                out.ans(IntMath.gcd(x, sum[n])).ln();
                continue;
            }
            int min = 0, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (IntMath.gcd(x, sum[mid]) > 1) min = mid;
                else max = mid;
            }
            out.ans(min + 1).ln();
        }
    }
}
