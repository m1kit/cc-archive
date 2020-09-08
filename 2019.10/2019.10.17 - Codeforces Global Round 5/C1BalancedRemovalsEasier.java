package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C1BalancedRemovalsEasier {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new P(i + 1, in.ints(), in.ints(), in.ints());
        }
        IntroSort.sort(ps, Comparator.comparing(p -> p.x));
        int xcur = 0;
        while (xcur < n) {
            int x = ps[xcur].x;
            PriorityQueue<P> yq = new PriorityQueue<>(Comparator.comparing(p -> p.y));
            while (ps[xcur].x == x) yq.offer(ps[xcur++]);

            while (!yq.isEmpty()) {
                int z = yq.peek().z;
                PriorityQueue<P> zq = new PriorityQueue<>(Comparator.comparing(p -> p.z));
                while (yq.peek().z == z) zq.offer(yq.poll());

            }
        }
    }

    private static class P {
        int index;
        int x, y, z;
        int cx, cy, cz;

        P(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        int dist(P o) {
            return Math.abs(x - o.x) + Math.abs(y - o.y) + Math.abs(z - o.z);
        }
    }
}
