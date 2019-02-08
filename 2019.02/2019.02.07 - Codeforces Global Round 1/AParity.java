package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AParity {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int b = in.ints(), k = in.ints();
        int[] a = in.ints(k);
        long val = 0;
        for (int i = 0; i < k; i++) {
            val *= b;
            val %= 2;
            val += a[i];
            val %= 2;
        }
        out.ans(val % 2 == 0 ? "even" : "odd"
        ).ln();
    }
}
