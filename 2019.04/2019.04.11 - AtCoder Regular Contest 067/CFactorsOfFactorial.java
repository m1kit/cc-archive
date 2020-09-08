package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CFactorsOfFactorial {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] cnt = new int[1001];
        for (int i = 2; i <= n; i++) {
            IntMath.primeFactorize(i).forEach((k, v) -> cnt[(int) ((long) k)] += v);
        }
        long ans = 1;
        for (int i = 0; i <= 1000; i++) {
            ans *= cnt[i] + 1;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
