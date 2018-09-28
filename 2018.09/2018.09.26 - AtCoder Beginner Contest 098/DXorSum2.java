package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class DXorSum2 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);

        int t = 0;
        int l = 0;
        long ans = 0;
        for (int r = 0; r < n; r++) {
            while ((t & a[r]) > 0) {
                t &= ~a[l];
                l++;
            }
            t |= a[r];
            ans += r - l + 1;
        }
        out.println(ans);
    }
}
