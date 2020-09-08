package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CExceptionHandling {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int[] b = a.clone();
        IntroSort.sort(b);
        for (int i = 0; i < n; i++) {
            if (a[i] == b[n - 1]) {
                out.ans(b[n - 2]).ln();
            } else {
                out.ans(b[n - 1]).ln();
            }
        }
    }
}
