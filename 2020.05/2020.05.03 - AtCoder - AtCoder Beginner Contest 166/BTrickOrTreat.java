package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTrickOrTreat {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[] a = new int[n];
        for (int i = 0; i < k; i++) {
            int d = in.ints();
            for (int x : in.ints(d)) a[x - 1]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) ans++;
        }
        out.ans(ans).ln();
    }
}
