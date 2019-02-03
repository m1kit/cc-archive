package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

public class BSimilarArrays {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 1;
        long exception = 1;
        for (int i = 0; i < n; i++) {
            ans *= 3;
            int a = in.ints();
            if (a % 2 == 0) {
                exception *= 2;
            }
        }
        out.ans(ans - exception).ln();
    }
}
