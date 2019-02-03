package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class ASuperheroTransformation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        String s = in.string(), t = in.string();
        if (s.length() != t.length()) {
            out.ans(NO).ln();
            return;
        }
        boolean[] vowels = new boolean[26];
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            vowels[c - 'a'] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (vowels[s.charAt(i) - 'a'] != vowels[t.charAt(i) - 'a']) {
                out.ans(NO).ln();
                return;
            }
        }
        out.ans(YES).ln();
    }
}
