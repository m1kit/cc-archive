package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class ANewYearAndTheChristmasOrnament {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long y = in.longs(), b = in.longs() - 1, r = in.longs() - 2;
        long min = IntMath.min(y, b , r);
        out.println(min * 3L + 3);
    }
}
