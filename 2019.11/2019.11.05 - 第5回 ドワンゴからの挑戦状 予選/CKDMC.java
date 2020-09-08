package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CKDMC {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) dp[i + 1] = dp[i] + (s[i] == 'D' ? 1 : 0);

        int queries = in.ints();
        for (int query = 0; query < queries; query++) {
            int k = in.ints();
            long sum = 0, ans = 0, count = 0;
            for (int i = 0; i < n; i++) {
                switch (s[i]) {
                    case 'M':
                        sum += dp[i + 1];
                        count++;
                        break;
                    case 'C':
                        ans += sum - count * dp[Math.max(0, i - k + 1)];
                        break;
                }

                if (i >= k && s[i - k] == 'M') {
                    sum -= dp[i - k];
                    count--;
                }
            }
            out.ans(ans).ln();
        }
    }
}
