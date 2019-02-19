package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.BitMath;

public class BFoodsLovedByEveryone {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans <<= 1;
            ans |= 1;
        }
        for (int i = 0; i < n; i++) {
            int k = in.ints();
            int p = 0;
            for (int j = 0; j < k; j++) {
                p |= (1 << (in.ints() - 1));
            }
            ans &= p;
        }
        out.ans(BitMath.count(ans)).ln();
    }
}
