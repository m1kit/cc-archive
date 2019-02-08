package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.MergeSort;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class BTape {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints(), k = in.ints();
        long[] b = in.longs(n);
        long[] d = new long[n - 1];
        for (int i = 1; i < n; i++) {
            d[i - 1] = b[i] - b[i - 1];
        }
        MergeSort.sort(d);

        long max = Arrays.stream(b).max().orElse(0);
        long min = Arrays.stream(b).min().orElse(0);
        long ans = max - min + 1;

        for (int i = 0; i < Math.min(k - 1, n - 1); i++) {
            ans -= d[n - 2 - i] - 1;
        }
        out.ans(ans).ln();
    }
}
