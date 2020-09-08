package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BHonestCoach {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            IntroSort.sort(a);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) ans = Math.min(ans, a[i] - a[i - 1]);
            out.ans(ans).ln();
        }
    }
}
