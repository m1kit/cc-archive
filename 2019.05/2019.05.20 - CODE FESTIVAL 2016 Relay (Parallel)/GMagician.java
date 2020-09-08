package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class GMagician {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), q = in.ints();
        boolean[] dp = new boolean[n];
        int c = 0;
        dp[0] = dp[1] = true;
        for (int i = 0; i < q; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            if (c == a) {
                c = b;
            } else if (c == b) {
                c = a;
            }

            if (dp[a] && !dp[b]) {
                dp[a] = false;
                dp[b] = true;
            } else if (dp[b] && !dp[a]) {
                dp[a] = true;
                dp[b] = false;
            }

            if (c > 0) {
                dp[c - 1] = true;
            }
            if (c < n - 1) {
                dp[c + 1] = true;
            }
        }

        //System.out.println(Arrays.toString(dp));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == c || dp[i]) ans++;
        }
        out.ans(ans).ln();
    }
}
