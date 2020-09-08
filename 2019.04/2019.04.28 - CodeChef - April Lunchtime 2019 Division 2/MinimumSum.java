package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.function.LongUnaryOperator;

public class MinimumSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            //long k = in.longs();
            long[] a = in.longs(n);
            LongUnaryOperator op = (x) -> {
                long ans = 0;
                for (int i = 0; i < n; i++) {
                    ans += a[i] ^ x;
                }
                return ans;
            };
            int[] count = new int[60];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < 60; j++) {
                    if (((a[i] >> j) & 1) == 1) {
                        count[j]++;
                    }
                }
            }

            long res = Long.MAX_VALUE;
            for (int i = 0; i < 60; i++) {
                long x = 0;
                for (int j = i; j >= 0; j--) {
                    long bit = 1L << j;
                    if (n <= 2 * count[j]) {
                        x ^= bit;
                    }
                }
                res = Math.min(res, op.applyAsLong(x));
            }
            out.ans(res).ln();
        }
    }
}
