package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ABalancedRatingChanges {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int odd = 0;
        for (int i = 0; i < n; i++) if (a[i] % 2 != 0) odd++;
        odd /= 2;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                out.ans(a[i] / 2).ln();
            } else if (odd-- > 0) {
                out.ans((a[i] + 1) / 2).ln();
            } else {
                out.ans((a[i] - 1) / 2).ln();
            }
        }
    }
}
