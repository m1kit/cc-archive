package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), t = in.ints();
        long[] a = in.longs(n);
        long ans = 0;
        long last = -10000000;
        for (int i = 0; i < n; i++) {
            if (a[i] < last + t) {
                ans += a[i] - last;
            } else {
                ans += t;
            }
            last = a[i];
        }
        out.println(ans);
    }
}
