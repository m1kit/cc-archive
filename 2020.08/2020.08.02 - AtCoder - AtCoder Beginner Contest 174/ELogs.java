package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ELogs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n);
        long min = 1, max = 1_000_000_010L;
        for (int i = 0; i < 60; i++) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += (a[j] + mid - 1) / mid;
            }
            if (cnt <= n + k) max = mid;
            else min = mid;
        }
        out.ans(max).ln();
    }
}
