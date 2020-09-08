package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class StaticRangeSum {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), q = in.ints();
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + in.longs();
        for (int i = 0; i < q; i++) {
            out.ans(-s[in.ints()] + s[in.ints()]).ln();
        }
    }
}
