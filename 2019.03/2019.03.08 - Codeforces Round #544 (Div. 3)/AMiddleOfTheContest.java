package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class AMiddleOfTheContest {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String[] a = in.string().split(":"), b = in.string().split(":");
        int t = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]) + Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
        t /= 2;
        int x = t / 60, y = t % 60;
        out.print((x < 10 ? "0" + x : x) + ":" + (y < 10 ? "0" + y : y)).ln();
    }
}
