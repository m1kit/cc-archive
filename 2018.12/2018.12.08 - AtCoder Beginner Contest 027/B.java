package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int total = Arrays.stream(a).sum();
        if (total % n != 0) {
            out.println(-1);
            return;
        }
        total /= n;
        int pm = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] + pm) != total) {
                ans++;
            }
            pm = a[i] + pm - total;
        }
        out.println(ans);
    }
}
