package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class CShift {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] str = in.chars();
        int k = in.ints();
        int[] a;
        int n;
        {
            List<Integer> rlc = new ArrayList<>();
            int count = 0;
            for (int i = str.length - 1; i >= 0; i--) {
                if (str[i] == '0') {
                    rlc.add(count);
                    count = 0;
                } else count++;
            }
            rlc.add(count);
            n = rlc.size();
            a = new int[n];
            for (int i = 0; i < n; i++) a[i] = rlc.get(i);
        }
        int ones = n - 1, zeros = str.length - ones;
        if (ones == 0 || zeros == 0) {
            out.ans(1).ln();
            return;
        }

        long[][][] dp = new long[n + 1][zeros + 1][zeros + 1];
        long[][] sum0 = new long[zeros + 1][zeros + 1], sum1 = new long[zeros + 1][zeros + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            // sum0
            for (int total = 0; total <= zeros; total++) {
                sum0[total][0] = dp[i][total][0];
                for (int now = 1; now <= zeros; now++) {
                    sum0[total][now] = (sum0[total][now - 1] + dp[i][total][now]) % MOD;
                }
            }
            // sum1
            for (int total = 0; total <= zeros; total++) {
                for (int now = 0; now <= zeros; now++) {
                    sum1[total][now] = dp[i][total][now];
                    if (total > 0 && now > 0) {
                        sum1[total][now] += sum1[total - 1][now - 1];
                        sum1[total][now] %= MOD;
                    }
                }
            }

            // thru
            for (int total = 0; total <= zeros; total++) {
                System.arraycopy(dp[i][total], 0, dp[i + 1][total], 0, zeros + 1);
            }

            // put
            for (int total = 0; total <= zeros; total++) {
                for (int now = 0; now <= total; now++) {
                    dp[i + 1][total][now] += (sum0[total][total] - sum0[total][now] + MOD);
                    dp[i + 1][total][now] %= MOD;
                }
            }

            // take
            for (int total = 1; total <= zeros; total++) {
                for (int now = 1; now <= total; now++) {
                    int min = Math.min(total, Math.min(now, a[i]));
                    /*for (int take = 1; take <= min; take++) {
                        dp[i + 1][total][now] += dp[i][total - take][now - take];
                    }*/
                    dp[i + 1][total][now] += sum1[total - 1][now - 1];
                    if (now - min - 1 >= 0) dp[i + 1][total][now] += MOD - sum1[total - min - 1][now - min - 1];
                    dp[i + 1][total][now] %= MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= Math.min(k, zeros); i++) ans += dp[n][i][0];
        out.ans(ans % MOD).ln();
    }
}
