package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.IntroSort;

public class CBalancedTeam {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);

        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (a[r] - a[l] > 5) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        out.ansln(ans);
    }
}
