package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.IntroSort;

public class BMikeAndChildren {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);

        int ans = 0;
        for (int sum = 2; sum <= 200_000; sum++) {
            int t = 0;
            int r = n - 1;
            for (int l = 0; l < n; l++) {
                while (r > l && a[l] + a[r] > sum) {
                    r--;
                }
                if (l == r) {
                    break;
                } else if (a[l] + a[r] == sum) {
                    t++;
                }
            }
            ans = Math.max(ans, t);
        }
        out.ansln(ans);
    }
}
