package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AOddSelection {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), x = in.ints();
            int[] count = new int[2];
            for (int i = 0; i < n; i++) count[in.ints() % 2]++;
            out.ans((x != n || count[1] % 2 == 1) && (count[1] > 0 && (count[0] > 0 || x % 2 == 1))).ln();
        }
    }
}
