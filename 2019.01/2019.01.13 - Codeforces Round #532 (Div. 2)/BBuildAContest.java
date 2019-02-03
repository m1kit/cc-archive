package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BBuildAContest {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        int[] b = new int[n];
        int[] c = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1;
            b[a]++;
            c[b[a]]++;
            if (c[b[a]] == n) {
                out.print('1');
            } else {
                out.print('0');
            }
        }
        out.ln();
    }
}
