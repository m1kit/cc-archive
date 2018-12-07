package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class AMultipleArray {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = new int[n];
        int[] b = new int[n];
        in.ints(a, b);
        long d = 0;
        for (int i = n - 1; i >= 0; i--) {
            d += (b[i] - ((a[i] + d) % b[i])) % b[i];
        }
        out.println(d);
    }
}
