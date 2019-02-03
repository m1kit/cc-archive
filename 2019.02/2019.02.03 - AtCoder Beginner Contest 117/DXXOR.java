package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.function.LongUnaryOperator;

public class DXXOR {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        long k = in.longs();
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

        long res = 0;
        for (int i = 0; i < 60; i++) {
            long x = 0;
            for (int j = i; j >= 0 ; j--) {
                long bit = 1L << j;
                if ((x ^ bit) > k) {
                    continue;
                } else if (n > 2 * count[j]) {
                    x ^= bit;
                }
            }
            res = Math.max(res, op.applyAsLong(x));
        }
        out.ans(res).ln();
    }
}
