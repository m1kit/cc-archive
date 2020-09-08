package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class AEhabFailsToBeThanos {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(2 * n);
        IntroSort.sort(a);
        if (a[0] == a[2 * n - 1]) {
            out.ans(-1).ln();
        } else {
            for (int i = 0; i < 2 * n; i++) {
                out.ans(a[i]);
            }
            out.ln();
        }
    }
}
