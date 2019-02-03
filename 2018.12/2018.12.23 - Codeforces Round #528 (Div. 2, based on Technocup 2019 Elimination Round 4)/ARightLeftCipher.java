package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ARightLeftCipher {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        int n = s.length();
        if (n % 2 == 0) {
            int m = n / 2 - 1;
            for (int i = 0; i < n; i++) {
                out.print(s.charAt(i % 2 == 0 ? m - i / 2 : m + (i + 1) / 2));
            }
        } else {
            int m = (n - 1) / 2;
            for (int i = 0; i < n; i++) {
                out.print(s.charAt(i % 2 == 0 ? m - i / 2 : m + (i + 1) / 2));
            }
        }
        out.println();
    }
}
