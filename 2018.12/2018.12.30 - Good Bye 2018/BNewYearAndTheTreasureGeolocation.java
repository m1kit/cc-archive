package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BNewYearAndTheTreasureGeolocation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] x = new long[n], y = new long[n];
        in.longs(x, y);
        long[] a = new long[n], b = new long[n];
        in.longs(a, b);
        long sx = LongStream.of(x).sum(), sy = LongStream.of(y).sum();
        long sa = LongStream.of(a).sum(), sb = LongStream.of(b).sum();
        long c = (sx + sa) / n, d = (sy + sb) / n;
        out.print(c);
        out.print(' ');
        out.println(d);
    }
}
