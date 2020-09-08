package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;

public class DXorSum4 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[][] sum = new int[60][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 60; j++) {
                sum[j][i] = sum[j][i + 1];
                if (((a[i] >> j) & 1) == 1) sum[j][i]++;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 60; j++) {
                int cnt = ((a[i] >> j) & 1) == 1 ? (n - i - 1) - sum[j][i + 1] : sum[j][i + 1];
                ans += (1L << j) % MOD * cnt % MOD;
                ans %= MOD;
            }
        }
        out.ans(ans).ln();
    }
}
