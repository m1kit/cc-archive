package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class CColoringTorus {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int k = in.ints();
        if (k == 1) {
            out.ans(1).ln().ans(1).ln();
            return;
        }
        int m = (k + 3) / 4;
        int n = m * 2;
        out.ans(n).ln();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = (i + j) % n + 1;
                if (i % 2 == 1 && v + n <= k) {
                    v += n;
                }
                out.ans(v);
            }
            out.ln();
        }
    }
}
