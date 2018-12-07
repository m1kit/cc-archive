package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AEhabAndAnotherConstructionProblem {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int x = in.ints();
        if (x == 1) {
            out.println(-1);
        } else {
            out.println(x + " " + x);
        }
    }
}
