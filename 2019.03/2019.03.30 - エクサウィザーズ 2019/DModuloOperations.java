package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DModuloOperations {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), x = in.ints();
        int[] s = in.ints(n);
        IntroSort.sort(s);
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(n + 1);

        long[][] dp = new long[n + 1][x + 1];
        dp[n][x] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= x; j++) {
                dp[i][j % s[i]] += dp[i + 1][j];
                dp[i][j % s[i]] %= MOD;
                dp[i][j] += dp[i + 1][j] * i % MOD;
                dp[i][j] %= MOD;
            }
        }

        //Stream.of(dp).map(Arrays::toString).forEach(System.out::println);

        long ans = 0;
        for (int i = 0; i <= x; i++) {
            ans += i * dp[0][i] % MOD;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
