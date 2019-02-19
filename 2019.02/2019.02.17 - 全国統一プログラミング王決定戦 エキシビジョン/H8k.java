package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class H8k {

    private static final String YES = "Win";
    private static final String NO = "Lose";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        boolean[] dp = {false, true, false, true, false, true, false, true, true};
        out.ansln(dp[(int) (in.longs() % 9)] ? YES : NO);
    }
}
