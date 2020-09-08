package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.Arrays;

public class D2017LikeNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[] c = new int[100_001];
        for (int i = 1; i <= 100_000; i++) {
            if (i % 2 == 1 && IntMath.isPrime(i) && IntMath.isPrime((i + 1) / 2)) {
                c[i] = c[i - 1] + 1;
            } else {
                c[i] = c[i - 1];
            }
        }
        //System.out.println(IntMath.isPrime(61));
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            int l = in.ints(), r = in.ints();
            out.ans(c[r] - c[l - 1]).ln();
        }
    }
}
