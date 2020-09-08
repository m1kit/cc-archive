package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DReplacing {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] cnt = new long[100_001];
        for (int i = 0; i < n; i++) cnt[in.ints()]++;
        long sum = 0;
        for (int i = 0; i <= 100_000; i++) sum += i * cnt[i];
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int b = in.ints(), c = in.ints();
            sum += (c - b) * cnt[b];
            cnt[c] += cnt[b];
            cnt[b] = 0;
            out.ans(sum).ln();
        }
    }
}
