package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class BComparison {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        BigInteger a = in.bigints(), b = in.bigints();
        if (a.compareTo(b) > 0) {
            out.println("GREATER");
        } else if (a.equals(b)) {
            out.println("EQUAL");
        } else {
            out.println("LESS");
        }
    }
}
