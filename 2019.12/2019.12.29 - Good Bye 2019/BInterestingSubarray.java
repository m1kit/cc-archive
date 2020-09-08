package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BInterestingSubarray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        loop: for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            for (int i = 0; i < n - 1; i++) {
                if (Math.abs(a[i] - a[i + 1]) > 1) {
                    out.yesln();
                    out.ans(i + 1).ans(i + 2).ln();
                    continue loop;
                }
            }
            out.noln();
        }
    }
}
