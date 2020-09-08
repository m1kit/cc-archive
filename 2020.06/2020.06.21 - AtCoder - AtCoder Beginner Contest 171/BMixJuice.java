package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BMixJuice {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[ ] a = in.ints(n);
        IntroSort.sort(a);
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        out.ans(sum).ln();
    }
}
