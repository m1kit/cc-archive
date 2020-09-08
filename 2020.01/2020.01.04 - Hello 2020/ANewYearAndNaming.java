package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ANewYearAndNaming {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        String[] s = in.string(n), t = in.string(m);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int x = in.ints() - 1;
            out.ans(s[x % n] + t[x % m]).ln();
        }
    }
}
