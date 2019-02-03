package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n), b = in.ints(m);
        Arrays.sort(a);
        Arrays.sort(b);
        int x = 0;
        int l = 0, r = 0;
        while (l < n && r < m) {
            if (a[l] == b[r]) {
                x++;
                l++;
                r++;
            } else if (a[l] < b[r]) {
                l++;
            } else {
                r++;
            }
        }
        out.println(x / (0.0 + n + m - x));
    }
}
