package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BPreparationForInternationalWomensDay {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[] d = in.ints(n);
        int ans = 0;


        int[] c = new int[k];
        for (int i = 0; i < n; i++) {
            c[d[i] % k]++;
        }

        ans += c[0] / 2;
        if (k % 2 == 0) {
            ans += c[k / 2] / 2;
        }

        //System.out.println(Arrays.toString(c));
        for (int i = 1; i <= (k - 1) / 2; i++) {
            ans += Math.min(c[i], c[k - i]);
        }
        out.ansln(2 * ans);
    }
}
