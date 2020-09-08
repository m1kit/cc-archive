package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ERedScarf {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= a[i];
        }
        for (int i = 0; i < n; i++) {
            out.ans(sum ^ a[i]);
        }
        out.ln();
    }
}
