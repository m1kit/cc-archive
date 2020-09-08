package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.Set;

public class F {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        Set<C> s = new HashSet<>();
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            s.add(new C(in.ints(), in.ints()));
        }
        out.ans(s.size()).ln();
    }

    private static class C {
        int x, y;

        public C(int x, int y) {
            this.x = Math.min(x, y);
            this.y = Math.max(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            C c = (C) o;

            if (x != c.x) return false;
            return y == c.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
