package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), q = in.ints();
        int[] a = new int[n];
        for (int i = 0; i < q; i++) {
            int l = in.ints() - 1, r = in.ints() - 1, t = in.ints();
            for (int j = l; j <= r; j++) {
                a[j] = t;
            }
        }
        Arrays.stream(a).forEach(out::println);
    }
}
