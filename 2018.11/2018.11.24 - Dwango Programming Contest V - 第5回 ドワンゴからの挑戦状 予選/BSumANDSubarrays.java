package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.BitMath;

import java.io.PrintWriter;

public class BSumANDSubarrays {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int k = in.ints();
        int[] a = in.ints(n);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }

        long ans = 0;
        for (int i = 62; i >= 0; i--) {
            long mask = ans | (1L << i);
            int c = 0;
            for (int r = 1; r < n; r++) {
                for (int l = 0; l < r; l++) {
                    long s = sum[r + 1] - sum[l];
                    if ((s & mask) == mask) {
                        c++;
                    }
                }
            }
            if (c >= k) {
                ans = mask;
            }
        }
        out.println(ans);
    }
}
