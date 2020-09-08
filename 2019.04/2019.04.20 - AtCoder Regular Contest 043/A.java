package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (IntMath.isPrime(n)) {
            out.ans("Prime").ln();
        } else if (n % 5 != 0 && n % 3 != 0 && n % 2 != 0 && n != 1) {
            out.ans("Prime").ln();
        } else {
            out.ans("Not Prime").ln();
        }
    }
}
