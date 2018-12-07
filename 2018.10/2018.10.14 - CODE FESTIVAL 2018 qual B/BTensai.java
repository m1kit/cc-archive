package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BTensai {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), x = in.ints();
        int[] a = new int[n];
        int[] b = new int[n];
        in.ints(a, b);

        int maxB = Arrays.stream(b).max().orElse(0);
        out.println(IntStream.range(0, n).mapToLong(i -> a[i] * b[i]).sum() + (maxB * x));
    }
}
