package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        long sum = 0;
        for (int i = 0; i < n; i ++) {
            int m = k;
            m -= Math.max(0, k - i - 1);
            m -= Math.max(0, k - n + i);
            sum += m * in.longs();
        }
        out.println(sum);
    }
}
