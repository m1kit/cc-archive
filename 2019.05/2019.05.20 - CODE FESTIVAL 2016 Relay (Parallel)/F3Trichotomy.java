package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class F3Trichotomy {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long[] t = {1, 2, 3};
        int x = in.ints();
        for (int i = 1; i < x; i++) {
            long sum = t[0] + t[1] + t[2];
            t[1] = sum;
            t[2] = sum + 1;
        }
        out.ans(t[0] + t[1] + t[2]).ln();
    }
}
