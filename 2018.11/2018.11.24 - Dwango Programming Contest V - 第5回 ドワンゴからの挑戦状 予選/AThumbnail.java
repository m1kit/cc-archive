package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class AThumbnail {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        double avg = IntStream.of(a).average().orElse(0);
        int mi = -1;
        double d = 1000000000;
        for (int i = 0; i < n; i++) {
            if (Math.abs(avg - a[i]) < d) {
                mi = i;
                d = Math.abs(avg - a[i]);
            }
        }
        out.println( mi);
    }
}
