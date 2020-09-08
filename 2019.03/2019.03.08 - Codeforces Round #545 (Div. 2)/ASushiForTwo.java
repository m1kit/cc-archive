package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class ASushiForTwo {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long ans = 0;

        for (int g = 0; g < 2; g++) {
            long[] k0 = new long[n], k1 = new long[n];
            k0[0] = a[0] == 1 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (a[i] == 1) {
                    k0[i] = k0[i - 1] + 1;
                }
            }
            k1[n - 1] = a[n - 1] == 2 ? 1 : 0;
            for (int i = n - 2; i >= 0; i--) {
                if (a[i] == 2) {
                    k1[i] = k1[i + 1] + 1;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                ans = Math.max(ans, Math.min(k0[i], k1[i + 1]));
            }

            ArrayUtil.reverse(a, 0, n);
        }
        out.ansln(2 * ans);
    }
}
