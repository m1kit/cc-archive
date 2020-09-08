package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.HashMap;
import java.util.Map;

public class CFactorsOfFactorial {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            for (Map.Entry<Long, Integer> ent : IntMath.primeFactorize(i).entrySet()) {
                cnt.merge(ent.getKey(), ent.getValue(), Integer::sum);
            }
        }
        long ans = 1;
        for (Map.Entry<Long, Integer> ent : cnt.entrySet()) {
            ans *= ent.getValue() + 1;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
