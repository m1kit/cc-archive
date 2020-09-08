package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AAddition {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                c++;
            }
        }
        out.ansln(c % 2 == 1 ? NO : YES);
    }
}
