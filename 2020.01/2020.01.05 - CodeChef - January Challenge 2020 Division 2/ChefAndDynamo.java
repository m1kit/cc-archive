package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ChefAndDynamo {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.enableAutoFlush();
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long pow = 1;
            for (int i = 0; i < n; i++) pow *= 10;
            long s = in.longs() + pow + pow;
            out.ans(s).ln();
            out.ans(pow - in.longs()).ln();
            out.ans(pow - in.longs()).ln();
            if (in.ints() == -1) return;
        }
    }
}
