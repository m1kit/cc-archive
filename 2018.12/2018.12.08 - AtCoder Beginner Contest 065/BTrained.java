package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BTrained {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        boolean[] walked = new boolean[n + 1];
        int c = 1;
        int ans = 0;
        while (!walked[c]) {
            ans++;
            walked[c] = true;
            c = a[c - 1];
            if (c == 2) {
                out.println(ans);
                return;
            }
        }
        out.println(-1);
    }
}
