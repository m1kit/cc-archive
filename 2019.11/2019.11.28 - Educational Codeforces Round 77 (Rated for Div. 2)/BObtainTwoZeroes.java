package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BObtainTwoZeroes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            long a = in.longs(), b = in.longs(), x = Math.max(a, b), y = Math.min(a, b), d = x - y;
            x -= 2 * d;
            y -= d;
            out.ans(x >= 0 && y >= 0 && x % 3 == 0 && y % 3 == 0);
        }
    }
}
