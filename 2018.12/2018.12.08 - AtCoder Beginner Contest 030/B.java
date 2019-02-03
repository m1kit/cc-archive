package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        double n = in.ints() % 12 * 30, m = in.ints() * 6;
        n += m / 12;
        out.println(Math.min((n - m + 360) % 360, (m - n + 360) % 360));
    }
}
