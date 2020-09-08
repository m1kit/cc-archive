package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class YC1065 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), start = in.ints() - 1, goal = in.ints() - 1;
        int[] px = new int[n], py = new int[n];
        in.ints(px, py);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing(x -> dist[x]));
        dist[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int nxt : adj.get(now)) {
                double d = dist[now] + Math.hypot(px[now] - px[nxt], py[now] - py[nxt]);
                if (dist[nxt] <= d) continue;
                dist[nxt] = d;
                q.offer(nxt);
            }
        }
        out.ans(dist[goal], 10).ln();
    }
}
