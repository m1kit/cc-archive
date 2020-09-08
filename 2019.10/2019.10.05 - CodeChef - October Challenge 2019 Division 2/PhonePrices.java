package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class PhonePrices {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int prev = Integer.MAX_VALUE;
                for (int j = Math.max(0, i - 5); j < i; j++)  prev = Math.min(prev, a[j]);
                if (a[i] < prev) ans++;
            }
            out.ans(ans).ln();
        }
    }
}
