package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class ASortedArrays {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        Boolean inc = null;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) {
            } else if (a[i - 1] < a[i]) {
                if (inc != null && !inc) {
                    ans++;
                    inc = null;
                } else {
                    inc = true;
                }
            } else {
                if (inc != null && inc) {
                    ans++;
                    inc = null;
                } else {
                    inc = false;
                }
            }
        }
        out.println(ans);
    }
}
