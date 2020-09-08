package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class HGrid1 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        String[] a = in.string(h);
        long[][] dp = new long[h][w];
        dp[0][0] = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i].charAt(j) == '#') continue;
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }
        out.ansln(dp[h - 1][w - 1]);
    }
}
