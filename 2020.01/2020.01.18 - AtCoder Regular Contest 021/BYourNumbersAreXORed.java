package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BYourNumbersAreXORed {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = new int[n], b = in.ints(n);
        for (int i = 1; i < n; i++) a[i] = a[i - 1] ^ b[i - 1];
        if ((a[0] ^ a[n - 1]) != b[n - 1]) out.ans(-1).ln();
        else out.ansln(a);
    }
}
