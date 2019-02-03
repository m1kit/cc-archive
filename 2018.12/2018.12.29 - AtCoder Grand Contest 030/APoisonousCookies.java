package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class APoisonousCookies {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long a = in.ints(), b = in.ints(), c = in.ints();
        if (a + b >= c) {
            out.println(b + c);
        } else {
            out.println(b + Math.min(a + b + 1, c));
        }
    }
}
