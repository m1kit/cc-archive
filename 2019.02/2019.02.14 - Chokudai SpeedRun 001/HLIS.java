package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class HLIS {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        int[] a = in.ints(n);
        int[] m = new int[n + 1];
        Arrays.fill(m, Integer.MAX_VALUE);
        m[0] = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = 0, max = n + 1;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (m[mid] < a[i]) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            m[max] = Math.min(m[max], a[i]);
            ans = Math.max(ans, max);
        }
        out.ansln(ans);

    }
}
