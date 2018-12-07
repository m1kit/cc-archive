package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ASimpleCalculator {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int x = in.ints(), y = in.ints();
        int ans = Integer.MAX_VALUE;
        // 00
        if (x <= y) {
            ans = Math.min(ans, y - x);
        }
        // 01
        if (x <= -y) {
            ans = Math.min(ans, 1 - x - y);
        }
        // 10
        if (-x <= y) {
            ans = Math.min(ans, 1 + x + y);
        }
        // 11
        if (-x <= -y) {
            ans = Math.min(ans, 2 -y + x);
        }
        out.println(ans);
    }
}
