package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CBeTogether {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = Long.MAX_VALUE;

        for (int i = -100; i <= 100; i++) {
            long t = 0;
            for (int j = 0; j < n; j++) {
                t += (a[j] - i) * (a[j] - i);
            }
            ans = Math.min(ans, t);
        }
        out.ansln(ans);
    }
}
