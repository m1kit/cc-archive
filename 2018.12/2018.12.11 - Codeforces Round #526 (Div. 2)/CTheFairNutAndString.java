package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class CTheFairNutAndString {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        long a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a += b;
                a += 1;
                a %= MOD;
            } else if (s.charAt(i) == 'b') {
                b = a;
            }
        }
        out.println(a);
    }
}
