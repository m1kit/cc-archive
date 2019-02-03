package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BKvassAndTheFairNut {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long s = in.longs();
        long[] v = in.longs(n);
        long min = Arrays.stream(v).min().orElse(1);
        long sum = Arrays.stream(v).sum();
        if (s > sum) {
            out.println(-1);
        } else {
            s -= (sum - min * n);
            if (s <= 0) {
                out.println(min);
            } else {
                out.println(min - ((s + n - 1L) / n));
            }
        }
    }
}
