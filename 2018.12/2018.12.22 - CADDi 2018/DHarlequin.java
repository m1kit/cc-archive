package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class DHarlequin {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                out.println("first");
                return;
            }
        }
        out.println("second");
    }
}
