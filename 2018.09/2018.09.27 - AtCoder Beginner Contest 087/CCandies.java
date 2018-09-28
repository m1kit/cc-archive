package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class CCandies {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();

        int[] a1 = IntMath.sum(in.ints(n));
        int[] a2 = IntMath.sum(in.ints(n));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a1[i + 1] + a2[n] - a2[i]);
        }
        out.println(ans);
    }


}
