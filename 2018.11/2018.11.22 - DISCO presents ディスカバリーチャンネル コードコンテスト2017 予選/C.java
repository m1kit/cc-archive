package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), c = in.ints();
        long[] l = in.longs(n);
        Arrays.sort(l);
        int ans = 0;
        int i = 0;
        for (int r = n - 1; r >= i; r--) {
            if (l[i] + l[r] < c) {
                i++;
            }
            ans++;
        }
        out.println(ans);
    }
}
