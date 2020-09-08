package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CNekoDoesMaths {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.longs(), b = in.longs();
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }

        if (a == 1 || a % b == 0) {
            out.ans(0).ln();
            return;
        }

        long d = b - a;
        long maxk = (a + d - 1) / d * d - a;
        long gcd = IntMath.gcd(a + maxk, b + maxk);

        long ansk = 0, ansv = IntMath.lcm(a, b);
        List<Map.Entry<Long, Integer>> es = new ArrayList<>(IntMath.primeFactorize(gcd).entrySet());
        long itr = 1;
        for (Map.Entry<Long, Integer> ent : es) {
            itr *= ent.getValue() + 1;
        }
        for (int i = 0; i < itr; i++) {
            long g = 1;
            int t = i;
            for (Map.Entry<Long, Integer> ent : es) {
                int p = t % (ent.getValue() + 1);
                t /= (ent.getValue() + 1);
                while (p > 0) {
                    g *= ent.getKey();
                    p--;
                }
            }

            long k = (a + g - 1) / g * g - a;
            long lcm = IntMath.lcm(a + k, b + k);
            if (lcm < ansv) {
                ansv = lcm;
                ansk = k;
            }
        }

        out.ans(ansk).ln();
    }
}
