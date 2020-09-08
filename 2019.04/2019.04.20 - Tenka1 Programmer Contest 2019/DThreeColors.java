package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.stream.IntStream;

public class DThreeColors {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int sum = IntStream.of(a).sum();
        ModMath mod = new ModMath(MOD);

        long[] dp0 = new long[sum + 1], dp1 = new long[sum + 1];
        dp0[0] = 1;
        dp1[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum - a[i]; j++) {
                dp0[j + a[i]] += dp0[j];
                dp0[j + a[i]] %= MOD;
                dp0[j] += dp0[j];
                dp0[j] %= MOD;

                dp1[j + a[i]] += dp1[j];
                dp1[j + a[i]] %= MOD;
            }
        }
        long ans = mod.pow(3, n);
        for (int i = (sum + 1) / 2; i <= sum; i++) {
            ans -= dp0[i] * 3;
            ans = (ans + 3L * MOD) % MOD;
        }
        if (sum % 2 == 0) {
            ans += 3 * dp1[sum / 2];
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
