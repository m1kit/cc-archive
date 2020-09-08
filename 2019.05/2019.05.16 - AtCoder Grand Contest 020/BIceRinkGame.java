package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BIceRinkGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        long low, high;
        {
            long min = 0, max = 1_000_000_000_000_000L;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                long t = mid;
                for (int i = 0; i < n; i++) t -= t % a[i];
                if (t >= 2) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            low = max;

            long t = low;
            for (int i = 0; i < n; i++) {
                t -= t % a[i];
            }
            if (t != 2) {
                out.ans(-1).ln();
                return;
            }
        }

        {
            long min = 0, max = 1_000_000_000_000_000L;
            while (max - min > 1) {
                long mid = (min + max) / 2;
                long t = mid;
                for (int i = 0; i < n; i++) t -= t % a[i];
                if (t <= 2) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            high = min;
        }
        out.ans(low).ans(high).ln();
    }
}
