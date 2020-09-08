package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CCountOrder {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] x = IntStream.rangeClosed(1, n).toArray(), y = IntStream.rangeClosed(1, n).toArray();
        int[] p = in.ints(n), q = in.ints(n);
        int a = 1, b = 1;
        while (!Arrays.equals(x, p)) {
            x = Permutation.nextPermutation(x);
            a++;
        }
        while (!Arrays.equals(y, q)) {
            y = Permutation.nextPermutation(y);
            b++;
        }
        out.ans(Math.abs(a - b)).ln();
    }
}
