package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        out.println((int) Math.pow(in.ints(), 0.25));
    }
}
