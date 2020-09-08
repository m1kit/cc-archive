package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AMisterBAndBookReading {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int c = in.ints(), v0 = in.ints(), v1 = in.ints(), a = in.ints(), l = in.ints();
        int ans = 0;
        int v = v0;
        int read = 0;
        while (read < c) {
            if (ans != 0) {
                read -= l;
            }
            ans++;
            read += v;
            v = Math.min(v + a, v1);
        }
        out.ans(ans).ln();
    }
}
