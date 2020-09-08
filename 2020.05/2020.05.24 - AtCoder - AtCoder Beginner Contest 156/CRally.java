package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CRally {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] x = in.ints(n);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            int res = 0;
            for (int j = 0; j < n; j++) {
                int d = i - x[j];
                res += d * d;
            }
            ans =Math.min(ans, res);
        }
        out.ans(ans).ln();
    }
}
