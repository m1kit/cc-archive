package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FSmallProducts {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();

        Set<Integer> sp = new HashSet<>();
        sp.add(0);
        int last = -1;
        for (int i = 1; i * i <= n; i++) {
            if (n / i != last) {
                sp.add(i);
                sp.add(n / i);
                last = n / i;
            }
        }

        int[] d = sp.stream().mapToInt(x -> x).toArray();
        IntroSort.sort(d);
        //System.out.println(d.length + " : " + Arrays.toString(d));
        int m = d.length;


        long[][] dp = new long[k][m];
        for (int i = 1; i < m; i++) {
            dp[0][i] = d[i] - d[i - 1];
        }

        for (int i = 1; i < k; i++) {
            dp[i][m - 1] = dp[i - 1][1];
            for (int l = m - 2; l >= 1; l--) {
                dp[i][l] = (dp[i][l + 1] + dp[i - 1][m - l]) % MOD;
            }

            for (int l = 1; l < m; l++) {
                dp[i][l] *= d[l] - d[l - 1];
                dp[i][l] %= MOD;
            }
        }

        long ans = 0;
        for (int i = 1; i < m; i++) {
            ans += dp[k - 1][i];
            ans %= MOD;
        }

        //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        out.ans(ans).ln();
    }
}
