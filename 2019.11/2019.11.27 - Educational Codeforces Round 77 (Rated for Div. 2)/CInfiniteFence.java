package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CInfiniteFence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            long r = in.longs(), b = in.longs(), k = in.longs();
            if ((Math.max(r, b) - IntMath.gcd(r, b) + Math.min(r, b) - 1) / Math.min(r, b) >= k) {
                out.ans("REBEL").ln();
            } else {
                out.ans("OBEY").ln();
            }
        }
    }
}
