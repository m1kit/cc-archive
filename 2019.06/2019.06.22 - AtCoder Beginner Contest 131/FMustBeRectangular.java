package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.*;

public class FMustBeRectangular {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        P[] p = new P[n];
        for (int i = 0; i < n; i++) {
            p[i] = new P(i, in.ints(), in.ints());
        }
        IntUnionFind uf = new IntUnionFind(n);
        IntroSort.sort(p, Comparator.comparing(q -> q.x));
        for (int i = 1; i < n; i++) {
            if (p[i - 1].x == p[i].x) {
                uf.union(p[i - 1].i, p[i].i);
            }
        }
        IntroSort.sort(p, Comparator.comparing(q -> q.y));
        for (int i = 1; i < n; i++) {
            if (p[i - 1].y == p[i].y) {
                uf.union(p[i - 1].i, p[i].i);
            }
        }

        Map<Integer, Set<Integer>> xsize = new HashMap<>(), ysize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != i) continue;
            xsize.put(i, new HashSet<>());
            ysize.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            int j = uf.find(p[i].i);
            xsize.get(j).add(p[i].x);
            ysize.get(j).add(p[i].y);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != i) continue;
            ans += xsize.get(i).size() * (long) ysize.get(i).size() - uf.size(i);
        }
        out.ans(ans).ln();
    }

    private static class P {
        int i, x, y;

        P(int i, int x, int y) {
            this.i = i;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            P p = (P) o;

            if (i != p.i) return false;
            if (x != p.x) return false;
            return y == p.y;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }
}
