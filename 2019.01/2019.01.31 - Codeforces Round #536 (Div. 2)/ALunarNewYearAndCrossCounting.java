package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ALunarNewYearAndCrossCounting {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        String[] s = in.string(n);
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (s[i].charAt(j) == 'X'
                && s[i - 1].charAt(j - 1) == 'X'
                && s[i - 1].charAt(j + 1) == 'X'
                && s[i + 1].charAt(j - 1) == 'X'
                && s[i + 1].charAt(j + 1) == 'X') {
                    ans++;
                }
            }
        }
        out.ans(ans).ln();
    }
}
