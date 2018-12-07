package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;

public class BGCD {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long z = in.longs();
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = IntMath.lcm(ans, IntMath.gcd(in.longs(), z));
        }
        out.println(ans);
    }
}
