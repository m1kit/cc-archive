package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DMinimumDiameterTree {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        double s = in.doubles();
        int[] c = new int[n];
        for (int i = 1; i < n; i++) {
            int x = in.ints(), y = in.ints();
            c[x - 1]++;
            c[y - 1]++;
        }
        long a = IntStream.of(c).filter(v -> v == 1).count();
        out.println(s * 2 / a);
    }
}
