package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CGarden {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long k = in.longs(), min = 0, max = 2_000_000_000_000_000_002L;
        long[] w = new long[n], d = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.longs();
            d[i] = in.longs();
        }
        while (max - min > 1) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                if (mid < w[i]) continue;
                cnt += 1 + (mid - w[i]) / d[i];
            }
            if (cnt >= k) {
                max = mid;
            } else {
                min = mid;
            }
        }
        out.ans(max).ln();
    }
}
