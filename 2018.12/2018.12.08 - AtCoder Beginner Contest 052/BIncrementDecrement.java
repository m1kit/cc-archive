package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BIncrementDecrement {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        in.voids();
        String s = in.string();
        int x = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            x += c == 'I' ? 1: -1;
            max = Math.max(max, x);
        }
        out.println(max);
    }
}
