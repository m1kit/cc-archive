package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ATheFairNutAndElevator {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = 1_000_000_000_000L;
        for (int x = 1; x <= 100; x++) {
            long t = 0;
            for (int i = 1; i <= n; i++) {
                t += a[i - 1] * (Math.abs(x - i) + Math.abs(i - 1) + Math.abs(x - 1));
            }
            ans = Math.min(ans, t * 2);
        }
        out.println(ans);
    }
}
