package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class BKEYENCEString {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        String s = in.string();
        if (s.matches("^(.*keyence|k.*eyence|ke.*yence|key.*ence|keye.*nce|keyen.*ce|keyenc.*e|keyence.*)$")) {
            out.ans(YES).ln();
        } else {
            out.ans(NO).ln();
        }
    }
}
