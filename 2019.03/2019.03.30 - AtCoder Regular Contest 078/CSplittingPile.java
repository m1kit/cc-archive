package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSplittingPile {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, Math.abs((sum[n] - sum[i]) - sum[i]));
        }
        out.ansln(ans);
    }
}
