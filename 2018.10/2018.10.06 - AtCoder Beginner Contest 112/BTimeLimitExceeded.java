package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BTimeLimitExceeded {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), t = in.ints();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = in.ints(), j = in.ints();
            if (j <= t) {
                min = Math.min(min, c);
            }
        }
        out.println(min == Integer.MAX_VALUE ? "TLE" : Integer.toString(min));
    }
}
