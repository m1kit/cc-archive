package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CACookieForYou {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long a = in.longs(), b = in.longs(), n = in.longs(), m = in.longs();
            if (a > b) b -= m;
            else a -= m;
            out.ans(a >= 0 && b >= 0 && a + b >= n).ln();
        }
    }
}
