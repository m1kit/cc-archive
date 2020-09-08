package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class ESumOfGcdOfTuplesHard {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        ModMath mod = new ModMath(MOD);
        int n = in.ints(), k = in.ints();
        long[] dp = new long[k + 1];
        long ans = 0;
        for (int i = k; i > 0; i--) {
            dp[i] = mod.pow(k / i, n);
            for (int j = 2 * i; j <= k; j += i) dp[i] += MOD - dp[j];
            dp[i] %= MOD;
            ans += dp[i] * i % MOD;
        }
        out.ans(ans % MOD).ln();
    }
}
