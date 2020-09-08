package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ETozanAndGezan {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = new long[n], b = new long[n];
        in.longs(a, b);
        long min = Long.MAX_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] > b[i]) min = Math.min(min, b[i]);
        }
        out.ans(min == Long.MAX_VALUE ? 0 : sum - min).ln();
    }
}
