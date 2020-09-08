package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class EGetEverything {

    private static final int INF = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Key[] keys = new Key[m];
        boolean[] ok = new boolean[n];
        for (int i = 0; i < m; i++) {
            int cost = in.ints(), b = in.ints(), open = 0;
            for (int j = 0; j < b; j++) {
                int box = in.ints() - 1;
                open |= 1 << box;
                ok[box] = true;
            }
            keys[i] = new Key(cost, open);
        }
        int[][] dp = new int[m + 1][1 << n];
        ArrayUtil.fill(dp, INF);
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(dp[i], 0, dp[i + 1], 0, (1 << n));
            for (int j = 0; j < (1 << n); j++) {
                int to = j | keys[i].open;
                dp[i + 1][to] = Math.min(dp[i + 1][to], dp[i][j] + keys[i].cost);
            }
        }
        int ans = dp[m][((1 << n) - 1)];
        out.ans(ans >= INF ? -1 : ans).ln();
    }

    private static class Key {
        int cost, open;

        Key(int cost, int open) {
            this.cost = cost;
            this.open = open;
        }
    }
}
