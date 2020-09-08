package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class ECountMedian {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = new long[n], b = new long[n];
        in.longs(a, b);
        IntroSort.sort(a);
        IntroSort.sort(b);
        if (n % 2 == 1) out.ans(b[n / 2] - a[n / 2] + 1).ln();
        else out.ans(b[n / 2] + b[n / 2 - 1] - a[n / 2] - a[n / 2 - 1] + 1).ln();
    }
}
