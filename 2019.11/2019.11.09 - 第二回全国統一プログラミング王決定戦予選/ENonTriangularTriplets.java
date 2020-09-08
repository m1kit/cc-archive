package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class ENonTriangularTriplets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long k = in.longs();
        long[] a = new long[n], b = new long[n], c = new long[n];
        for (int i = 0; i < n; i++) c[i] = k + 2 * n + i;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            a[i] = k + ((n - 1) / 2) - i;
            b[i] = k + n + i * 2;
        }
        for (int i = (n + 1) / 2; i < n; i++) {
            int j = i - ((n + 1) / 2);
            a[i] = k + (n - 1) - j;
            b[i] = k + n + j * 2 + 1;
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] > c[i]) {
                ok = false;
                break;
            }
        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        //System.out.println(Arrays.toString(c));

        if (!ok) {
            out.ans(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            out.ans(a[i]).ans(b[i]).ans(c[i]).ln();
        }
    }
}
