package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B754 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        long ans = 973261980476L;
        for (int i = 0; i < s.length() - 2; i++) {
            ans = Math.min(ans, Math.abs(753 - Integer.parseInt(s.substring(i, i + 3))));
        }
        out.println(ans);
    }
}
