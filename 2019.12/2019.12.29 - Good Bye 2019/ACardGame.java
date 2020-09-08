package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class ACardGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), x = in.ints(), y = in.ints();
            int[] a = in.ints(x), b = in.ints(y);
            IntroSort.sort(a);
            IntroSort.sort(b);
            out.ans(a[x - 1] > b[y - 1]).ln();
        }
    }
}
