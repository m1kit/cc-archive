package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.sort.BinaryInsertionSort;
import jp.llv.atcoder.lib.sort.InsertionSort;
import jp.llv.atcoder.lib.sort.MergeSort;
import jp.llv.atcoder.lib.sort.TimSort;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class BArrayStabilization {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        MergeSort.sort(a);
        out.ans(Math.min(a[n - 1] - a[1], a[n - 2] - a[0])).ln();
    }
}
