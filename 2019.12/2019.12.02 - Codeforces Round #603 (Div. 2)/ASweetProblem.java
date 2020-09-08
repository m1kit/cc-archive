package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class ASweetProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] a = in.ints(3);
            Arrays.sort(a);
            if (a[0] + a[1] <= a[2]) out.ans(a[0] + a[1]).ln();
            else out.ans((a[0] + a[1] + a[2]) / 2).ln();
        }
    }
}
