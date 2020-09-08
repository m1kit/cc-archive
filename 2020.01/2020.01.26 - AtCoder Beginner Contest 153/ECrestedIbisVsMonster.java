package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class ECrestedIbisVsMonster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), n = in.ints();
        int[] a = new int[n], b = new int[n];
        in.ints(a, b);
        int[] dp = new int[h + 1];
        ArrayUtil.fill(dp, 1_000_000_000);
        dp[h] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = h; j > 0; j--) {
                int d = Math.max(j - a[i], 0);
                dp[d] = Math.min(dp[d], dp[j] + b[i]);
            }
        }
        out.ans(dp[0]).ln();
    }
}
