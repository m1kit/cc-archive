package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AGennadyAndACardGame {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String[] s = in.string(6);
        for (int i = 1; i <= 5; i++) {
            if (s[0].charAt(0) == s[i].charAt(0) || s[0].charAt(1) == s[i].charAt(1)) {
                out.println(YES);
                return;
            }
        }
        out.println(NO);
        return;
    }
}
