package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class BChladniFigure {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        HashSet<Edge> edges = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            edges.add(new Edge(x, y));
        }

        outer: for (int k = 1; k < n; k++) {
            if (n % k != 0) continue;

            for (Edge e : edges) {
                Edge corsp = new Edge((e.x + k) % n, (e.y + k) % n);
                if (!edges.contains(corsp)) continue outer;
            }
            out.yesln();
            return;
        }
        out.noln();
    }

    private static class Edge {
        int x, y;

        public Edge(int x, int y) {
            this.x = Math.min(x, y);
            this.y = Math.max(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (x != edge.x) return false;
            return y == edge.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
