package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class MAutoChoice {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        E[] es = new E[n + m];
        for (int i = 0; i < n + m; i++) es[i] = new E(in.longs(), in.longs(), i >= n);
        double min = 0, max = 1 << 17;
        bisearch: for (int i = 0; i < 40; i++) {
            double mid = (min + max) / 2;
            Arrays.sort(es, Comparator.comparing(e -> mid * e.mass - e.magic));
            boolean[] used = new boolean[n + m];
            long magic = 0, mass = 0;
            int count = 0;
            for (int j = 0; count < 4; j++) {
                if (j == n + m) return;
                if (es[j].exclusive) continue;
                count++;
                used[j] = true;
                magic += es[j].magic;
                mass += es[j].mass;
            }

            for (int j = 0; j < n + m; j++) {
                if (used[j]) continue;
                if ((magic + es[j].magic) >= mid * (mass + es[j].mass)) {
                    min = mid;
                    continue bisearch;
                }
            }
            max = mid;
        }
        out.ans(min, 13).ln();
    }

    private static class E {
        long mass, magic;
        boolean exclusive;

        public E(long mass, long magic, boolean exclusive) {
            this.mass = mass;
            this.magic = magic;
            this.exclusive = exclusive;
        }
    }
}
