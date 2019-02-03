package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.IntMath;

public class BContests {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int a = in.ints(), b = in.ints();
        int[] p = in.ints(n);
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] <= a) {
                x++;
            } else if (p[i] <= b) {
                y++;
            } else {
                z++;
            }
        }
        out.ans(IntMath.min(x, y, z)).ln();
    }
}
