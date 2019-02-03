package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BAtCoDeerPaintingBallsWithAtCoDeer {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        int ans = k;
        for (int i = 1; i < n; i++) {
            ans *= (k - 1);
        }
        out.println(ans);
    }
}
