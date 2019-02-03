package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BSimplifiedMahjong {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] % 2 == 1 && a[i + 1] > 0) {
                a[i]--;
                a[i + 1]--;
                ans += 1;
            }
        }
        //System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            ans += a[i] / 2;
        }
        out.println(ans);
    }
}
