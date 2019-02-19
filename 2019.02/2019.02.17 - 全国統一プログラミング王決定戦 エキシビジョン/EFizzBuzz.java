package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class EFizzBuzz {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        for (int i = 1; i <= n; i++) {
            boolean f = true;
            if (i % 2 == 0) {
                out.print('a');
                f = false;
            }
            if (i % 3 == 0) {
                out.print('b');
                f = false;
            }
            if (i % 4 == 0) {
                out.print('c');
                f = false;
            }
            if (i % 5 == 0) {
                out.print('d');
                f = false;
            }
            if (i % 6 == 0) {
                out.print('e');
                f = false;
            }
            if (f) {
                out.ansln(i);
            } else {
                out.ln();
            }
        }
    }
}
