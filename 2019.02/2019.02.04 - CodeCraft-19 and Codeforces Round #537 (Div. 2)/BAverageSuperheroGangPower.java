package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class BAverageSuperheroGangPower {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints(), m = in.ints();
        int[] a = in.ints(n);
        Arrays.sort(a);
        ArrayUtil.reverse(a, 0, n);

        long sum = 0;
        double max = 0;
        int top = 0;
        int cur = 0;
        int inc = 0;
        int trained = 0;
        for (int i = 0; i <= m; i++) {
            int heroes = n - m + i;
            if (heroes <= 0) {
                continue;
            }
            while (top < heroes) {
                sum += a[top];
                top++;
            }
            while (trained < i && inc < top) {
                sum++;
                cur++;
                if (cur == k) {
                    cur = 0;
                    inc++;
                }
                trained++;
            }
            double val = sum / (double) heroes;
            max = Math.max(max, val);
        }
        out.ans(max, 12).ln();
    }
}
