package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ALCMProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long l = in.longs(), r = in.longs();
            if (l * 2 <= r) out.ans(l).ans(l * 2).ln();
            else out.ans(-1).ans(-1).ln();
        }
    }
}
