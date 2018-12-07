package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DBigBang {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] ax = new long[n], ay = new long[n];
        long[] bx = new long[n], by = new long[n];
        in.longs(ax, ay);
        in.longs(bx, by);
        out.println(Math.sqrt(rad(bx, by) / rad(ax, ay)));
    }

    private static double d(double x1, double y1, long x2, long y2) {
        return (x1 - x2) *  (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    private static double rad(long[] x, long[] y) {
        double xs = LongStream.of(x).sum();
        double ys = LongStream.of(y).sum();
        double m = 0;
        xs /= x.length;
        ys /= y.length;
        for (int i = 0; i < x.length; i++) {
            double t = d(xs, ys, x[i], y[i]);
            if (t > m) {
                m = t;
            }
        }
        return m;
    }
}
