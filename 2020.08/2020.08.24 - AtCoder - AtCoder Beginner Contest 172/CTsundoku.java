package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTsundoku {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(),ans=0;
        long k = in.longs();
        long[] a = new long[n + 1], b = new long[m + 1];
        for (int i = 0; i < n; i++) a[i + 1] = a[i] + in.longs();
        for (int i = 0; i < m; i++) b[i + 1] = b[i] + in.longs();
        int cur = m;
        for (int i = 0; i <= n && a[i] <= k; i++) {
            while (a[i] + b[cur] > k) cur--;
            ans = Math.max(ans, i + cur);
        }
        out.ans(ans).ln();
    }
}
