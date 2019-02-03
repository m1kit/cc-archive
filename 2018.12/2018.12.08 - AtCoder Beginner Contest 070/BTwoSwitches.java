package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class BTwoSwitches {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] a = in.ints(4);
        boolean[] b = new boolean[101];
        for (int i = a[0]; i <= a[1]; i++) {
            b[i] = true;
        }
        int ans = 0;
        for (int i = a[2]; i <= a[3]; i++) {
            if (b[i]) {
                ans++;
            }
        }
        out.println(Math.max(0, ans - 1));
    }
}
