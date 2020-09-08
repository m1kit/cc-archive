package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CArraySplitting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }
        IntroSort.sort(d);
        long ans = a[n - 1] - a[0];
        for (int i = 0; i < k - 1; i++) {
            ans -= d[n - 2 - i];
        }
        out.ans(ans).ln();
    }
}
