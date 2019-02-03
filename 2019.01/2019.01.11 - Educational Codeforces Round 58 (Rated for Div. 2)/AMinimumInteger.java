package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

public class AMinimumInteger {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            long l = in.longs(), r = in.longs(), d = in.longs();
            if (d < l) {
                out.ans(d).ln();
            } else {
                out.ans((r + d) / d * d).ln();
            }
        }
    }
}
