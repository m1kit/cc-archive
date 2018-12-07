package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] h = new long[n], s = new long[n];
        in.longs(h, s);
        long min = 0, max = 100_001_000_000_000L;
        long[] mor = new long[n];
        outer: while (max - min > 1) {
            long mid = (min + max + 1) / 2;
            for (int i = 0; i < n; i++) {
                if (mid < h[i]) {
                    min = mid;
                    continue outer;
                }
                mor[i] = (mid - h[i]) / s[i];
            }
            Arrays.sort(mor);
            for (int i = 0; i < n; i++) {
                if (mor[i] < i) {
                    min = mid;
                    continue outer;
                }
            }
            max = mid;
        }
        out.println(max);
    }
}
