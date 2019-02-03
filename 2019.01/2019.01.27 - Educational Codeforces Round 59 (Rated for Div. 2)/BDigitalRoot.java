package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BDigitalRoot {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            long k = in.longs();
            int x = in.ints();
            for (long j = (k - 1) * 9 + 1;; j++) {
                if (root(j) == x) {
                    out.ans(j).ln();
                    break;
                }
            }
        }
    }

    public static int root(long n) {
        if (n < 10) {
            return (int) n;
        }
        String s = Long.toString(n);
        long sum = 0;
        for ( char c : s.toCharArray()) {
            sum += c - '0';
        }
        return root(sum);
    }
}
