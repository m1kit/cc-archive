package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AColorfulSubsequence {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s = in.string();

        int[] chars  = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        long ans = 1;
        for (int i = 0; i < 26; i++) {
            ans *= (chars[i] + 1);
            ans %= MOD;
        }
        ans += MOD - 1;
        ans %= MOD;
        out.ansln(ans);
    }
}
