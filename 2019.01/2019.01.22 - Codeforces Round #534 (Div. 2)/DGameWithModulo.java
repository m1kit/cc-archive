package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class DGameWithModulo {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static final long MAX = 1_000_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        out.enableAutoFlush();
        String type = in.string();
        while ("start".equals(type)) {
            long min = 0, max = 1;
            char r = 'y';
            while (max <= MAX) {
                out.ans('?').ans(min).ans(max).ln();
                r = in.string().charAt(0);
                if (r != 'y') {
                    break;
                } else {
                    min = max;
                    max *= 2;
                }
            }
            while (max - min > 1) {
                long mid = (min + max) / 2;
                out.ans('?').ans(min).ans(mid).ln();
                r = in.string().charAt(0);
                if (r == 'y') {
                    min = mid;
                } else {
                    max = mid ;
                }
            }
            out.ans('!').ans(max).ln();
            type = in.string();
        }
    }
}
