package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BDivisorsOfTwoIntegers {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int[] d = in.ints(n);
        MergeSort.sort(d);
        int a = d[n - 1];
        List<Integer> div = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                div.add(i);
            }
        }
        int c = 0;
        for (int de : div) {
            while (d[c] != de) {
                c++;
            }
            d[c] = 0;
            c++;
        }
        MergeSort.sort(d);
        int b = d[n - 1];
        out.ans(a).ans(b).ln();
    }
}
