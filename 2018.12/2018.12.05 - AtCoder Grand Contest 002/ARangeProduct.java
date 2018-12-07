package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ARangeProduct {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long a = in.longs(), b = in.longs();
        if (a * b <= 0) {
            out.println("Zero");
        } else if (a > 0 || (b - a) % 2 == 1) {
            out.println("Positive");
        } else {
            out.println("Negative");
        }
    }
}
