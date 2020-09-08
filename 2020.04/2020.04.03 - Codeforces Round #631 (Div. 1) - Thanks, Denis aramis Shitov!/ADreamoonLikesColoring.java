package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class ADreamoonLikesColoring {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] l = in.ints(m), p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i;
            if (n < p[i] + l[i]) {
                out.ans(-1).ln();
                return;
            }
        }
        int goal = n;
        for (int i = m - 1; i >= 0; i--) {
            int d = Math.max(0, goal - (p[i] + l[i]));
            p[i] += d;
            goal = p[i];
        }
        //System.out.println(Arrays.toString(p));
        if (p[0] != 0) {
            out.ans(-1).ln();
            return;
        }
        for (int i = 0; i < m; i++) out.ans(p[i] + 1);
        out.ln();
    }

    private static class P {
        int c, l, ans;

        P(int c, int l) {
            this.c = c;
            this.l = l;
        }
    }
}
