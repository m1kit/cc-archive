package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), a = in.ints(), b = in.ints();
        int x = 0;
        for (int i = 0; i < n; i++) {
            String s = in.string();
            int d = Math.max(a, Math.min(b, in.ints()));
            if (s.equals("East")) {
                x += d;
            } else {
                x -= d;
            }
        }
        if (x == 0) {
            out.println(0);
        } else if (x > 0) {
            out.println("East " + x);
        } else {
            out.println("West " + (-x));
        }
    }
}
