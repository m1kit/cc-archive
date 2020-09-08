package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTravelingSalesmanAroundLake {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints(), n = in.ints();
        int[] a = in.ints(n);
        int ans =  a[n - 1] - a[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, k - (a[i] - a[i - 1]));
        }
        out.ans(ans).ln();
    }
}
