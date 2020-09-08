package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class DPrimeGraph {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        //for (int n = 3; n <= 1000; n++) {
            int np = n;
            while (!IntMath.isPrime(np)) np++;
            out.ans(np).ln();
            for (int i = 0; i < n; i++) {
                out.ans(i + 1).ans((i + 1) % n + 1).ln();
            }
            for (int i = 0; i < np - n; i++) {
                if (i + 1 >= n - i - 1) throw new RuntimeException();
                out.ans(i + 1).ans(n - i - 1).ln();
            }
        //}
    }
}
