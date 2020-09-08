package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMagicalCalendar {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), r = in.longs(), ans = r < n ? 0 : 1;
            long s = Math.min(n - 1, r);
            ans += s * (s + 1L) / 2;
            out.ans(ans).ln();
        }
    }
}
