package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.IntMath;

public class DDivGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        long ans = 0;
        for (int t : IntMath.primeFactorize(n).values()) {
            //System.out.println(t);
            int d = 1;
            while (d <= t) {
                t-=d++;
                ans++;
            }
        }
        out.ans(ans).ln();
    }
}
