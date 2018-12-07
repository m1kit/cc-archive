package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BEhabAndSubtraction {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n);
        Arrays.sort(a);
        long d = 0;
        int i = 0;
        for (int c = 0; c < k; c++) {
            while (i < n && a[i] - d == 0) {
                i++;
            }
            if (i < n) {
                out.println(a[i] - d);
                d = a[i];
            } else {
                out.println(0);
            }
        }
    }
}
