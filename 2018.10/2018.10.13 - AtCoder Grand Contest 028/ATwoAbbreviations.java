package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class ATwoAbbreviations {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long n = in.longs(), m = in.longs();
        String s = in.string(), t = in.string();
        long lcm = IntMath.lcm(n, m);
        long gcd = n * m / lcm;
        int x = 0, y = 0;
        for (int i = 0; i < gcd; i++) {
            if (s.charAt(x) != t.charAt(y)) {
                out.println(-1);
                return;
            }
            x += n /gcd;
            y += m / gcd;
        }
        out.println(lcm);
    }
}
