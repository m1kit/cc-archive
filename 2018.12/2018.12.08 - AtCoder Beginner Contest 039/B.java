package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] a = in.ints(4);
        if (a[0] == a[2] || a[1] == a[2] || a[0] == a[3] || a[1] == a[3]) {
            out.println(YES);
        } else {
            out.println(NO);
        }
    }
}
