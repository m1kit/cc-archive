package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

public class ABulletinBoard {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] x = in.ints(3);
        out.ans((x[0] - x[1] + 1) * (x[0] - x[2] + 1));
    }
}
