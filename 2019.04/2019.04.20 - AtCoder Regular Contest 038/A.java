package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                x += a[i];
            } else {
                y += a[i];
            }
        }
        out.ans(Math.max(x, y)).ln();
    }
}
