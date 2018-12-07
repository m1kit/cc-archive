package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.math.LongModMath;
import jp.llv.atcoder.lib.math.ModMath;

import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int y = n;
        long ans = 0;
        for (int x = 1; x <= n; x++) {
            while (x * y > n) {
                y--;
            }
            ans += (pow(x, 10) - pow(x - 1, 10) + MOD) % MOD * pow(y, 10) % MOD;
            ans %= MOD;
        }
        out.println(ans);
    }

    public static long pow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long z = pow(x, y / 2);
            return (z * z) % MOD;
        } else {
            return (x % MOD) * pow(x, y - 1) % MOD;
        }
    }
}
