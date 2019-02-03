package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.counting.Permutation;

public class CNiceGarland {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        char[] perm = {'B', 'G', 'R'};
        String s = in.string();
        int ans = Integer.MAX_VALUE;
        char[] ansp = null;
        while (perm != null) {
            int t = 0;
            for (int i = 0; i < n; i++) {
                if (perm[i % 3] != s.charAt(i)) {
                    t++;
                }
            }
            if (t < ans) {
                ans = t;
                ansp = perm.clone();
            }
            perm = Permutation.nextPermutation(perm);
        }
        out.ans(ans).ln();
        for (int i = 0; i < n; i++) {
            out.print(ansp[i % 3]);
        }
        out.ln();
    }
}
