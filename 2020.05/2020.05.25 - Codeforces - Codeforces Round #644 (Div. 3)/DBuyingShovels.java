package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DBuyingShovels {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), k = in.longs(), ans = Long.MAX_VALUE;
            for (long i = 1; i * i <= n; i++) {
                if (n % i != 0) continue;
                if (i <= k) ans = Math.min(ans, n / i);
                if (n / i <= k) ans = Math.min(ans, i);
            }
            out.ans(ans).ln();
        }
    }
}
