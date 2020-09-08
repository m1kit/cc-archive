package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class I {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (n == 1) {
            out.ans(1).ln();
            return;
        }
        PriorityQueue<Q> q = new PriorityQueue<>(Comparator.comparing(x -> -(x.x * x.y)));
        for (int i = 0; i < n; i++) {
            q.offer(new Q(i, in.ints(), in.ints()));
        }
        Q a = q.poll();
        while (!q.isEmpty()) {
            Q b = q.poll();
            if ((a.x + b.y - 1) / b.y == (b.x + a.y - 1) / a.y) {
                out.ans(-1).ln();
                return;
            }
        }
        out.ans(a.idx + 1).ln();
    }

    private static class Q {
        int idx;
        long x, y;

        public Q(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Q{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
