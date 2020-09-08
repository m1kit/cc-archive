package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DHandstand2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[][] cnt = new int[10][10];
        for (int i = 1; i <= n; i++) {
            int head = i, tail = i % 10;
            while (head >= 10) head /= 10;
            cnt[head][tail]++;
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ans += cnt[i][j] * cnt[j][i];
            }
        }
        out.ans(ans).ln();
    }
}
