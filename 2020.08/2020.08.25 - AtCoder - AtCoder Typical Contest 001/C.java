package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.NTT;

import java.util.Arrays;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter out) {
        int n = in.ints();
        long[] a = new long[n], b = new long[n];
        in.longs(a, b);
        long[] res = new NTT().convolve(a, b);
        System.out.println(Arrays.toString(res));
        out.ans(0).ln();
        for (int i = 0; i < 2 * n - 1; i++) out.ans(res[i]).ln();
    }
}
