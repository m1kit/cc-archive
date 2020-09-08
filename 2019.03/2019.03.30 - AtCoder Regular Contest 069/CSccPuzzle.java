package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSccPuzzle {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs(), m = in.longs();
        long min = 0, max = 1_000_000_000_000L;
        while (max - min > 1) {
            long mid = (max + min) / 2;
            long an = Math.max(mid, n);
            long am = m - (an - n) * 2L;
            if (am >= 2 * mid) {
                min = mid;
            } else {
                max = mid;
            }
        }
        out.ansln(min);
    }
}
