package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AShiritori {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String a = in.string(), b = in.string(), c = in.string();
        if (a.charAt(a.length() - 1) != b.charAt(0)) {
            out.println(NO);
        } else if (b.charAt(b.length() - 1) != c.charAt(0)) {
            out.println(NO);
        } else {
            out.println(YES);
        }
    }
}
