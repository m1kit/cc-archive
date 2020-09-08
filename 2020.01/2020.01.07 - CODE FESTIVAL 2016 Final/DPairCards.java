package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DPairCards {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), ans = 0;
        int[] cnt = new int[100_001], total = new int[m], pairs = new int[m];
        for (int i = 0; i < n; i++) cnt[in.ints()]++;
        for (int i = 0; i < m; i++) {
            for (int j = i; j <= 100_000; j += m) {
                total[i] += cnt[j];
                pairs[i] += cnt[j] / 2;
            }
        }
        for (int i = 0; i <= m / 2; i++) {
            if (i * 2 % m == 0) ans += total[i] / 2;
            else {
                ans += Math.min(total[i], total[m - i]);
                if (total[i] > total[m - i]) ans += Math.min((total[i] - total[m - i]) / 2, pairs[i]);
                if (total[i] < total[m - i]) ans += Math.min((total[m - i] - total[i]) / 2, pairs[m - i]);
            }
        }
        out.ans(ans).ln();
    }
}
