package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ATwoDistinctPoints {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int[] c = in.ints(4);
            int a = c[0], b = c[3];
            if (a == b) {
                if (c[0] != c[1]) {
                    a++;
                } else {
                    b--;
                }
            }
            out.ans(a).ans(b).ln();
        }
    }
}
