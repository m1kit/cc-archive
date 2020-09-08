package dev.mikit.atcoder;

import com.sun.org.apache.xpath.internal.operations.Mod;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.Arrays;

public class BExtension {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int a1 = in.ints(), b1 = in.ints(), a2 = in.ints(), b2 = in.ints();
        int ad = a2 - a1, bd = b2 - b1;
        ModMath mod = new ModMath(MOD);
        if (ad == 0 || bd == 0) {
            out.ans(mod.pow(a1, bd) * mod.pow(b1, ad) % MOD).ln();
            return;
        }
        long[][][] dp = new long[2][a2 + 1][b2 + 1];
        dp[0][a1][b1] = 1;
        for (int i = a1 + 1; i <= a2; i++) dp[0][i][b1] = dp[0][i - 1][b1] * b1 % MOD;
        for (int i = b1 + 1; i <= b2; i++) {
            dp[0][a1][i] = dp[0][a1][i - 1] * (a1 - 1) % MOD;
            dp[1][a1][i] += dp[0][a1][i - 1];
            dp[1][a1][i] += dp[1][a1][i - 1] * a1;
            dp[1][a1][i] %= MOD;
        }

        for (int i = a1 + 1; i <= a2; i++) {
            for (int j = b1 + 1; j <= b2; j++) {
                dp[1][i][j] += dp[0][i][j - 1];
                dp[1][i][j] += dp[1][i][j - 1] * i % MOD;
                dp[1][i][j] %= MOD;


                //dp[0][i][j] += dp[0][i][j - 1] * (i - 1) % MOD;
                dp[0][i][j] += dp[0][i - 1][j] * j % MOD;
                dp[0][i][j] += dp[1][i - 1][j] * j % MOD;
                dp[0][i][j] %= MOD;
            }
        }
        long ans = (dp[0][a2][b2] + dp[1][a2][b2]) % MOD;
        out.ans(ans).ln();
        //Arrays.stream(dp[0]).map(Arrays::toString).forEach(System.out::println);
        //Arrays.stream(dp[1]).map(Arrays::toString).forEach(System.out::println);

        /*
        long inv2 = new ModMath(MOD).inv(2);

        dp[0][a1][b1] = 1;
        for (int i = a1 + 1; i <= a2; i++) {
            dp[0][i][b1] = dp[0][i - 1][b1] * (b1 - 1) % MOD;
            dp[1][i][b1] = (dp[1][i - 1][b1] + dp[0][i - 1][b1]) % MOD;
        }
        for (int i = b1 + 1; i <= b2; i++) {
            dp[0][a1][i] = dp[0][a1][i - 1] * (a1 - 1) % MOD;
            dp[2][a1][i] = (dp[2][a1][i - 1] + dp[0][a1][i - 1]) % MOD;
        }


        for (int i = a1 + 1; i <= a2; i++) {
            for (int j = b1 + 1; j <= b2; j++) {
                dp[0][i][j] += dp[0][i - 1][j] * (j - 1) % MOD;
                dp[0][i][j] += dp[0][i][j - 1] * (i - 1) % MOD;
                dp[0][i][j] += dp[1][i][j - 1] * (i - 1) % MOD;
                dp[0][i][j] += dp[2][i - 1][j] * (j - 1) % MOD;
                //dp[0][i][j] += dp[0][i - 1][j - 1] * (i - 1) % MOD * (j - 1) % MOD;
                //dp[0][i][j] += dp[1][i - 1][j - 1] * (i - 1) % MOD * (j - 1) % MOD;
                //dp[0][i][j] += dp[2][i - 1][j - 1] * (i - 1) % MOD * (j - 1) % MOD;
                dp[0][i][j] %= MOD;

                dp[1][i][j] += dp[0][i - 1][j];
                dp[1][i][j] += dp[1][i - 1][j];
                dp[1][i][j] += dp[2][i - 1][j];
                dp[1][i][j] += dp[1][i - 1][j] * (j - 1) % MOD;
                dp[1][i][j] %= MOD;

                dp[2][i][j] += dp[0][i][j - 1];
                dp[2][i][j] += dp[1][i][j - 1];
                dp[2][i][j] += dp[2][i][j - 1];
                dp[2][i][j] += dp[2][i][j - 1] * (i - 1) % MOD;
                dp[2][i][j] %= MOD;
            }
        }

        long ans = (dp[0][a2][b2] + dp[1][a2][b2] + dp[2][a2][b2]) % MOD;
        out.ans(ans).ln();*/
    }
}
