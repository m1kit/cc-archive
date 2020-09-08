package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DShortestPathOnALine {

    private static final long INF = (long) 1e16 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Bridge[] bridges = new Bridge[m];
        for (int i = 0; i < m; i++) {
            bridges[i] = new Bridge(in.ints() - 1, in.ints() - 1, in.longs());
        }
        PriorityQueue<Bridge> q = new PriorityQueue<>(Comparator.comparing(bridge -> bridge.costFrom0));
        PriorityQueue<Bridge> b = new PriorityQueue<>(Comparator.comparing(bridge -> bridge.s));
        for (int i = 0; i < m; i++) b.offer(bridges[i]);
        while (!b.isEmpty() && b.peek().s == 0) q.offer(b.poll());
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek().t < i) q.poll();
            if (q.isEmpty()) break;
            long cost = q.peek().costFrom0;
            //System.out.println("i=" + i + ": " + cost);
            while (!b.isEmpty() && b.peek().s <= i) {
                Bridge peek = b.poll();
                peek.costFrom0 += cost;
                q.offer(peek);
            }
        }
        out.ans(q.isEmpty() ? -1 : q.peek().costFrom0);
    }

    private static class Bridge {
        int s, t;
        long cost;
        long costFrom0;

        Bridge(int s, int t, long cost) {
            this.s = s;
            this.t = t;
            this.cost = cost;
            this.costFrom0 = cost;
        }
    }
}
