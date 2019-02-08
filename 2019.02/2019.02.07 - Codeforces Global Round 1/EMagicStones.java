package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.Arrays;

public class EMagicStones {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] c = in.longs(n), t = in.longs(n);
        if (c[0] != t[0] || c[n - 1] != t[n - 1]) {
            out.ans(NO).ln();
            return;
        }
        long[] d = new long[n - 1], s = new long[n - 1];
        for (int i = 1; i < n; i++) {
            d[i - 1] = c[i] - c[i - 1];
            s[i - 1] = t[i] - t[i - 1];
        }
        MergeSort.sort(d);
        MergeSort.sort(s);
        for (int i = 0; i < n - 1; i++) {
            if (d[i] != s[i]) {
                out.ans(NO).ln();
                return;
            }
        }
        out.ans(YES).ln();
    }
}
