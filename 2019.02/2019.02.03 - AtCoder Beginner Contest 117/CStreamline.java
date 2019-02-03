package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CStreamline {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        int[] x = in.ints(m);
        if (n > m) {
            out.ans(0).ln();
            return;
        }
        Arrays.sort(x);
        int maxx = x[m - 1] - x[0];
        int[] d = new int[m - 1];
        for (int i = 1; i < m; i++) {
            d[i - 1] = x[i - 1] - x[i];
        }
        Arrays.sort(d);

        //System.out.println(maxx);
        //System.out.println(Arrays.toString(x));
        //System.out.println(Arrays.toString(d));
        for (int i = 1; i < n; i++) {
            maxx += d[i - 1];
        }
        out.ans(maxx).ln();
    }
}
