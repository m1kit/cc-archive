package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.mod.ModMath;

import java.io.PrintWriter;

public class BTrainingCamp {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        ModMath m = new ModMath();
        int n = in.ints();
        out.println(m.getFactorial(n + 1).fact(n));
    }
}
