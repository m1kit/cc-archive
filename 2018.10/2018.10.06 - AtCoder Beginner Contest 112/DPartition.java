package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class DPartition {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        for (int i = (m + n) / n; i >= 1; i--) {
            if (m % i != 0 || m / i < n) {
                continue;
            }
            out.println(i);
            return;
        }
    }
}
