package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class A {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int y = in.ints(), m = in.ints(), d = in.ints();
        if (m <= 2) {
            y -= 1;
            m += 12;
        }
        int r = 365 * y + (y / 4) - (y / 100) + (y / 400) + (306 * (m + 1) / 10) + d - 429;
        out.println(735369 - r);
    }
}
