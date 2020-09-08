package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AParkLighting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), m = in.longs();
            if (n % 2 == 0) {
                out.ans(n / 2 * m).ln();
            } else if (m % 2 == 0) {
                out.ans(m / 2 * n).ln();
            } else {
                out.ans(m / 2 * n + (n + 1) / 2).ln();
            }
        }
    }
}
