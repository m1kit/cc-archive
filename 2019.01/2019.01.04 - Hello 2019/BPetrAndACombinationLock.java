package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BPetrAndACombinationLock {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int m = 1 << n;
        int[] a = in.ints(n);
        for (int i = 0; i < m; i++) {
            long t = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    t += a[j];
                } else {
                    t -= a[j];
                }
            }
            if (((t % 360) + 360) % 360 == 0) {
                out.println(YES);
                return;
            }
        }
        out.println(NO);
    }
}
