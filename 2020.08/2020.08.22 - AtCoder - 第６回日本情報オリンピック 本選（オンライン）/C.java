package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        P[] ps = new P[n];
        HashSet<P> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ps[i] = new P(in.ints(), in.ints());
            set.add(ps[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dx = ps[j].x - ps[i].x, dy = ps[j].y - ps[i].y;
                P p2 = new P(ps[j].x - dy, ps[j].y + dx);
                P p3 = new P(p2.x - dx, p2.y - dy);
                if (!set.contains(p2) || !set.contains(p3)) continue;
                ans = Math.max(ans, dx * dx + dy * dy);
            }
        }
        out.ans(ans).ln();
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
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }
    }
}
