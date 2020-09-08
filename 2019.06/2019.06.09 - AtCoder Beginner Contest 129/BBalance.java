package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.stream.LongStream;

public class BBalance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] w = in.longs(n);

        long y = LongStream.of(w).sum();
        long x = 0;
        long ans = y;
        for (int i = 0; i < n; i++) {
            y -= w[i];
            x += w[i];
            ans = Math.min(ans, Math.abs(x - y));
        }
        out.ans(ans).ln();
    }
}
