package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.Map;

public class YC1063 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs(), a1 = 1, a2 = 1;
        Map<Long, Integer> map = IntMath.primeFactorize(n);
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) a1 *= entry.getKey();
            for (int i = 0; i < entry.getValue() / 2; i++) a2 *= entry.getKey();
        }
        out.ans(a2).ans(a1).ln();
    }
}
