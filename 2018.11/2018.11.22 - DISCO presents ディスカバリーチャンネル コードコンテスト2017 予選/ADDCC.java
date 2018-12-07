package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ADDCC {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        out.println(s.charAt(0) == s.charAt(1) && s.charAt(1) != s.charAt(2) && s.charAt(2) == s.charAt(3) ? YES: NO);
    }
}
