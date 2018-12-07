package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class AIceTeaStore {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long q = in.ints(), h = in.ints(), s = in.ints(), d = in.ints();
        int n = in.ints();
        long min2 = IntMath.min(8 * q, 4 * h, 2 * s, d);
        long min1 = IntMath.min(4 * q, 2 * h, s);
        out.println(n / 2 * min2 + n % 2 * min1);
    }
}
