package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class CLamps {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        int[] d = new int[n];
        boolean updated = true;
        for (int t = 0; t < k && updated; t++) {
            updated = false;
            for (int i = 0; i < n; i++) {
                d[Math.max(i - a[i], 0)]++;
                if (i + a[i] + 1 < n) d[i + a[i] + 1]--;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += d[i];
                if (a[i] == count) continue;
                updated = true;
                a[i] = count;
            }
            Arrays.fill(d, 0);
        }
        for (int i = 0; i < n; i++) {
            out.ans(a[i]);
        }
        out.ln();
    }

    private static class T {
        int i, d;

        T(int i, int d) {
            this.i = i;
            this.d = d;
        }
    }
}
