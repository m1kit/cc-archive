package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BChristmasEveEve {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] p = in.ints(n);
        Arrays.sort(p);
        long sum = IntStream.of(p).sum() - (p[n - 1] / 2);
        out.println(sum);
    }
}
