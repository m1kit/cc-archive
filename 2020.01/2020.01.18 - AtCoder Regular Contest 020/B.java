package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), c = in.ints();
        int[][] cnt = new int[2][10];
        for (int i = 0; i < n; i++) cnt[i % 2][in.ints() - 1]++;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                ans = Math.min(ans, n - cnt[0][i] - cnt[1][j]);
            }
        }
        out.ans(ans * c).ln();
    }
}
