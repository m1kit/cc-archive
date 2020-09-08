package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class ADivde {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {


        int[] dp = new int[101];
        for (int i = 2; i <= 100; i++) {
            boolean[] h = new boolean[101];
            for (int j = 1; j < i; j++) {
                if (i % j != 0) continue;
                h[dp[j]] = true;
            }
            for (int j = 0; j <= 100; j++) {
                if (!h[j]) {
                    dp[i] = j;
                    break;
                }
            }
        }

        int n = in.ints();
        long xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= dp[in.ints()];
        }
        out.ans(xor != 0).ln();
    }

}
