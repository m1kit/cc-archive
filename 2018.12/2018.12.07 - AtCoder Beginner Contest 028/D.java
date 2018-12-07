package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        double p = 1L + 3L * (n - 1L) + 6L * (n - k) * (k - 1L);
        p /= n;
        p /= n;
        p /= n;
        out.println(p);
    }
}
