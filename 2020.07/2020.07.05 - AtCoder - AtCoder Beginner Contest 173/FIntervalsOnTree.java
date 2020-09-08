package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FIntervalsOnTree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (i + 1L) * (n - i);
        for (int i = 1; i < n; i++) {
            int u = in.ints() - 1, v = in.ints() - 1;
            int min = Math.min(u, v), max = Math.max(u, v);
            ans -= (min + 1L) * (n - max);
        }
        out.ans(ans).ln();
    }
}
