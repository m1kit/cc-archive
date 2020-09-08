package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FModularness {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints(), q = in.ints();
        long[] d = in.longs(k);
        for (int i = 0; i < q; i++) {
            long n = in.longs() - 1, x = in.longs(), m = in.longs();
            long cycle = 0, sum = x % m;
            for (int j = 0; j < k; j++) cycle += mod(d[j], m);
            sum += cycle * (n / k);
            for (int j = 0; j < (n % k); j++) sum += mod(d[j], m);
            //System.out.println(sum);
            out.ans(n - sum / m).ln();
        }
    }

    private static long mod(long x, long m) {
        return (x + m - 1) % m + 1;
    }
}
