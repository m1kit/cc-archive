package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class APrefixAndSuffix {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        String s = in.string(), t = in.string();
        for (int i = 0; i <= n; i++) {
            if (t.startsWith(s.substring(i))) {
                out.println(n + i);
                return;
            }
        }
    }
}
