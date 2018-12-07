package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ABiscuits {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), p = in.ints();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f |= in.ints() & 1;
        }
        if (f == 1) {
            out.println(1L << (n - 1));
        } else if (p == 0) {
            out.println(1L << n);
        } else {
            out.println(0);
        }
    }
}
