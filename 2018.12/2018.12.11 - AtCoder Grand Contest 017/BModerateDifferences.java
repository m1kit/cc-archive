package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BModerateDifferences {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long a = in.longs(), b = in.longs(), c = in.longs(), d = in.longs();
        for (int i = 0; i < n; i++) {
            long max = a + d * i - c * (n - 1 - i);
            long min = a + c * i - d * (n - 1 - i);
            if (min <= b && b <= max) {
                out.println(YES);
                return;
            }
        }
        out.println(NO);
    }
}
