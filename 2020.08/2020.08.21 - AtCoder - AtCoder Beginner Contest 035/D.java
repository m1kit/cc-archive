package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), t = in.ints();
        long[] a = in.longs(n);
        List<List<Edge>> nat = new ArrayList<>();
        List<List<Edge>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nat.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1, c = in.ints();
            nat.get(x).add(new Edge(y, c));
            rev.get(y).add(new Edge(x, c));
        }
        long[] dnat = new long[n], drev = new long[n];
        Arrays.fill(dnat, 2_000_000_000_000_000_000L);
        Arrays.fill(drev, 2_000_000_000_000_000_000L);
        dnat[0] = 0;
        drev[0] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(node -> dnat[node]));
        pq.offer(0);
        while (!pq.isEmpty()) {
            int node = pq.poll();
            //System.out.println(node);
            for (Edge edge : nat.get(node)) {
                if (dnat[node] + edge.cost >= dnat[edge.to]) continue;
                dnat[edge.to] = dnat[node] + edge.cost;
                pq.offer(edge.to);
            }
        }
        pq.offer(0);
        while (!pq.isEmpty()) {
            int node = pq.poll();
            //System.out.println(node);
            for (Edge edge : rev.get(node)) {
                if (drev[node] + edge.cost >= drev[edge.to]) continue;
                drev[edge.to] = drev[node] + edge.cost;
                pq.offer(edge.to);
            }
        }
        //System.out.println(Arrays.toString(dnat));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (dnat[i] + drev[i] > t) continue;
            ans = Math.max(ans, (t - dnat[i] - drev[i]) * a[i]);
        }
        out.ans(ans).ln();
    }

    private static class Edge {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
