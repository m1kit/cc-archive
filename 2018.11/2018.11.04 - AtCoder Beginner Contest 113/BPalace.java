package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BPalace {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), t = in.ints() * 1000, a = in.ints() * 1000;
        Long min = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int h = in.ints();
            long abs = Math.abs(a - t + 6 * h);
            if (abs < min) {
                min = abs;
                index = i;
            }
        }
        out.println(index + 1);
    }
}
