package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BCD {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] a = IntStream.rangeClosed(0, n).toArray(), b = IntStream.rangeClosed(0, n).toArray();
        for (int i = 0; i < m; i++) {
            int x = in.ints();
            int pos = b[x];
            a[pos] = a[0];
            b[a[0]] = pos;
            a[0] = x;
            b[x] = 0;
        }
        for (int i = 1; i <= n; i++) out.ans(a[i]).ln();

    }
}
