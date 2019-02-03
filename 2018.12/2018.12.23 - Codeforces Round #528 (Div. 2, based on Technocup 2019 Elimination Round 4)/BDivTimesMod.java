package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BDivTimesMod {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long n = in.ints(), k = in.ints();
        long ans = Long.MAX_VALUE;
        for (int m = 1; m < k; m++) {
            if (n % m != 0) {
                continue;
            }
            ans = Math.min(n / m * k + m, ans);
        }
        out.println(ans);
    }
}
