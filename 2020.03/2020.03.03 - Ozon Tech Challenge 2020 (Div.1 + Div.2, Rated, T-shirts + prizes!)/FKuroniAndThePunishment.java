package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FKuroniAndThePunishment {

    private static final Random rand = new Random();

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        Set<Long> cand = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            long x = a[rand.nextInt(n)];
            if (x == 1) continue;
            cand.addAll(IntMath.primeFactorize(x - 1).keySet());
            cand.addAll(IntMath.primeFactorize(x).keySet());
            cand.addAll(IntMath.primeFactorize(x + 1).keySet());
        }
        long ans = n;
        for (long x : cand) {
            long t = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] <= x) t += x - a[i];
                else {
                    long r = a[i] % x;
                    t += Math.min(r, x - r);
                }
            }
            ans = Math.min(ans, t);
        }
        out.ans(ans).ln();
    }
}
