package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BChooseIntegers {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int a = in.ints(), b = in.ints(), c = in.ints();
        int gcd = gcd(a, b);
        out.println(c % gcd == 0 ? YES : NO);
    }

    private static int gcd(int a, int b) {
        int t;
        while (a % b > 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return b;
    }
}
