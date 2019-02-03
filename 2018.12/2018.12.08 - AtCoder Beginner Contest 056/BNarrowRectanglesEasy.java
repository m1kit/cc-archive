package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BNarrowRectanglesEasy {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int w = in.ints(), a = in.ints(), b = in.ints();
        int min = Math.min(a, b);
        int max = Math.max(a, b) + w;
        out.println(Math.max(0, max - min - w - w));
    }
}
