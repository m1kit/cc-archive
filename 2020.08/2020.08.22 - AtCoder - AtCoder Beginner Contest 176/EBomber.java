package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;
import dev.mikit.atcoder.lib.structure.IntMultiSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EBomber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints(), m = in.ints();
        int[] c1 = new int[h], c2 = new int[w];
        HashSet<P> set = new HashSet<>();
        List<Integer> cols = new ArrayList<>(), rows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            c1[x]++;
            c2[y]++;
            set.add(new P(x, y));
        }
        int rmax = IntMath.max(c1);
        int cmax = IntMath.max(c2);
        for (int i = 0; i < h; i++) {
            if (c1[i] == rmax) rows.add(i);
        }
        for (int i = 0; i < w; i++) {
            if (c2[i] == cmax) cols.add(i);
        }
        if (cols.size() * (long) rows.size() > m) {
            out.ans(cmax + rmax).ln();
            return;
        }
        for (int c : cols) {
            for (int r : rows) {
                P p = new P(r, c);
                if (!set.contains(p)) {
                    out.ans(cmax + rmax).ln();
                    return;
                }
            }
        }
        out.ans(cmax + rmax - 1).ln();
    }

    private static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            P p = (P) o;

            if (x != p.x) return false;
            return y == p.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
