package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AAlarmClock {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long a = in.ints(), b = in.ints(), c = in.ints(), d = in.ints();
            if (a <= b) {
                out.ans(b).ln();
            } else if (c <= d) {
                out.ans(-1).ln();
            } else {
                out.ans((a - b + c - d - 1) / (c - d) * c + b).ln();
            }
        }
    }
}
