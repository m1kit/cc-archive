package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.Set;

public class D {
    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        P[] a = new P[n];
        for (int i = 0; i < n; i++) a[i] = new P(in.ints(), in.ints());
        int m = in.ints();
        Set<P> set = new HashSet<>();
        for (int i = 0; i < m; i++) set.add(new P(in.ints(), in.ints()));

        loop:
        for (P origin : set) {
            int dx = origin.x - a[0].x, dy = origin.y - a[0].y;
            for (int i = 0; i < n; i++) {
                if (!set.contains(new P(a[i].x + dx, a[i].y + dy))) continue loop;
            }
            out.ans(dx).ans(dy).ln();
            return;
        }
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
