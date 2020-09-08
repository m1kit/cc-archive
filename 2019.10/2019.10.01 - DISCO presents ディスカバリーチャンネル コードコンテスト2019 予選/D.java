package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.LongChineseRemainder;

public class D {

    private static final String INVALID = "invalid";

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        LongChineseRemainder cr = new LongChineseRemainder();
        int[] a = in.ints(29);
        try {
            for (int i = 1; i <= 29; i++) cr.grow(a[i - 1] % i, i);
        } catch (RuntimeException ex) {
            out.ans(INVALID).ln();
            return;
        }
        if (cr.getRemainder() > 1_000_000_000_000L) {
            out.ans(INVALID).ln();
            return;
        }
        for (int i = 2; i <= 30; i++) {
            long rem = cr.getRemainder();
            int sum = 0;
            while (rem > 0) {
                sum += rem % i;
                rem /= i;
            }
            if (sum != a[i - 2]) {
                out.ans(INVALID).ln();
                return;
            }
        }
        out.ans(cr.getRemainder()).ln();
    }
}
