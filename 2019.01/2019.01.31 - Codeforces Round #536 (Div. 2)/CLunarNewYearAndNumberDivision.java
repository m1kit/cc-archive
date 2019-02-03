package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.MergeSort;

public class CLunarNewYearAndNumberDivision {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int[] a = in.ints(n);
        MergeSort.sort(a);
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            long s = a[i] + a[j];
            ans += s * s;
        }
        out.ans(ans).ln();
    }
}
