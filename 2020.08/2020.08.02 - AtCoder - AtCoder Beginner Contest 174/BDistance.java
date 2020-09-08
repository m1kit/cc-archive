package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BDistance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long d = in.longs(), ans = 0;
        for (int i = 0; i < n; i++) {
            long x = in.longs(), y = in.longs();
            long r = x * x + y * y;
            if (r <= d * d) ans++;
        }
        out.ans(ans).ln();
    }
}
