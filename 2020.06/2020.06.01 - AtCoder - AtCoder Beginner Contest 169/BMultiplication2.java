package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BMultiplication2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long prod = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0 && Long.MAX_VALUE / a[i] <= prod) prod = Long.MAX_VALUE;
            else prod *= a[i];
        }
        out.ans(prod <= 1000000000000000000L ? prod : -1).ln();
    }
}
