package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class DFlippingSigns {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long sum = 0;
        int neg = 0;
        long maxneg = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                sum += a[i];
            } else {
                neg++;
                sum -= a[i];
            }
            maxneg = Math.min(maxneg, Math.abs(a[i]));
        }
        if (neg % 2 == 1) {
            sum -= 2 * maxneg;
        }
        out.ans(sum).ln();
    }
}
