package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AABProblem {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), a = in.ints(), b = in.ints();
        long max = (n - 1L) * b + a;
        long min = (n - 1L) * a + b;
        out.println(Math.max(0, max - min + 1));
    }
}
