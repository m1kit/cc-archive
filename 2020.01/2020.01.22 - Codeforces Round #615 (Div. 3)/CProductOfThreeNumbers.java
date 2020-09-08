package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.*;

public class CProductOfThreeNumbers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        loop: for (int testCase = 0; testCase < testCases; testCase++) {
            long n = in.longs();
            List<Long> factors = new ArrayList<>();
            IntMath.primeFactorize(n).forEach((k, v) -> {
                for (int i = 0; i < v; i++) factors.add(k);
            });
            for (int i = 0; i < 100; i++) {
                long a = 1, b = 1, c = 1;
                for (long f : factors) {
                    if (Math.random() * 3 < 1) a *= f;
                    else if (Math.random() * 2 < 1) b *= f;
                    else c *= f;
                }
                boolean ok = a != b && b != c && c != a && a >= 2 && b >= 2 && c >= 2;
                if (ok) {
                    out.yesln().ans(a).ans(b).ans(c).ln();
                    continue loop;
                }
            }
            out.noln();
        }
    }
}
