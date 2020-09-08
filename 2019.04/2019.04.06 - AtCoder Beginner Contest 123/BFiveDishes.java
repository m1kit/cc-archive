package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;

import java.util.stream.IntStream;

public class BFiveDishes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] a = in.ints(5);
        int[] p = IntStream.range(0, 5).toArray();
        int ans = 1000000;
        while (p != null) {
            int t = 0;
            for (int i = 0; i < 5; i++) {
                while ( t % 10 > 0) {
                    t++;
                }
                t += a[p[i]];
            }
            ans = Math.min(ans, t);
            p = Permutation.nextPermutation(p);
        }
        out.ansln(ans);
    }
}
