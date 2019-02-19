package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class G {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] c = new int[26];
        String s = in.string();
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            if (c[i] % 2 == 0) {
                sum += c[i];
            } else {
                ans++;
                sum += c[i] - 1;
            }
        }
        if (ans > 0) {
            sum++;
            ans--;
        }
        out.ansln(sum * sum + ans);
    }
}
