package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CCelexUpdate {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long x1 = in.longs(), y1 = in.longs(), x2 = in.longs(), y2 = in.longs();
            out.ans(1 + Math.abs(x1 - x2) * Math.abs(y1 - y2)).ln();
        }
    }
}
