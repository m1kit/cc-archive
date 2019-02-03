package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class CSnukeFestival {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n), c = in.ints(n);
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long ans = 0;
        long[] v = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            v[i] = v[i + 1] + n - ArrayUtil.upperBound(c, b[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += v[ArrayUtil.upperBound(b, a[i])];
        }
        out.println(ans);
    }
}
