package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BEasyLinearProgramming {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int a = in.ints(), b = in.ints(), c = in.ints(), k = in.ints();
        out.ans(a + b < k ? 2 * a + b - k : Math.min(a, k)).ln();
    }
}
