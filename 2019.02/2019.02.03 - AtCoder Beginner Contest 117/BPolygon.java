package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BPolygon {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int[] l = in.ints(n);
        Arrays.sort(l);
        int sum = Arrays.stream(l).sum();
        sum -= l[n - 1];
        if (l[n - 1] < sum) {
            out.ans(YES).ln();
        } else {
            out.ans(NO).ln();
        }
    }
}
