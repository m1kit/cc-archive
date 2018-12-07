package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AZeroSumRanges {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        Map<Long, Integer> c = new HashMap<>();
        for (long x : sum) {
            c.merge(x, 1, (v1, v2) -> v1 + v2);
        }
        long ans = 0;
        for (int m : c.values()) {
            ans += m * (m - 1L) / 2;
        }
        out.println(ans);
    }
}
