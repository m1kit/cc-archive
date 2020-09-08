package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BreakingBricks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int s = in.ints(), ans = 0, cur = 0;
            int[] a = in.ints(3);
            while (cur < 3) {
                int t = s;
                ans++;
                while (cur < 3 && a[cur] <= t) {
                    t -= a[cur++];
                }
            }
            out.ans(ans).ln();
        }
    }
}
