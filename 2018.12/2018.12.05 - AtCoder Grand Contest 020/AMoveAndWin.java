package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AMoveAndWin {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), a = in.ints(), b = in.ints();
        if ((b - a) % 2 == 0) {
            out.println("Alice");
        } else {
            out.println("Borys");
        }
    }
}
