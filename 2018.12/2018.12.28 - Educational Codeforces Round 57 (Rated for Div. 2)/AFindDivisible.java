package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AFindDivisible {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int t = in.ints();
        for (int i = 0; i < t; i++) {
            long l = in.longs(), r = in.longs();
            out.print(l);
            out.print(' ');
            out.println(2 * l);
        }
    }
}
