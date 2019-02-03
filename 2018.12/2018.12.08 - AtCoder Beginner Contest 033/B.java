package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long total = 0;
        int max = 0;
        String ml = null;
        for (int i = 0; i < n; i++) {
            String s = in.string();
            int p = in.ints();
            if (p > max) {
                max = p;
                ml = s;
            }
            total += p;
        }
        if (max * 2 > total) {
            out.println(ml);
        } else {
            out.println("atcoder");
        }
    }
}
