package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class CBlueBird {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            long c = in.longs();
            nodes[x].adj.add(new Edge(i, c, nodes[y]));
            nodes[y].adj.add(new Edge(i, c, nodes[x]));
        }
        long ans = Long.MAX_VALUE;
        for (Edge edge : nodes[0].adj) {
            long[] cost = new long[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[edge.to.index] = 0;
            PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> cost[node.index]));
            q.offer(edge.to);
            while (!q.isEmpty()) {
                Node now = q.poll();
                if (visited[now.index]) continue;
                visited[now.index] = true;
                for (Edge e : now.adj) {
                    if (e.index == edge.index) continue;
                    if (cost[now.index] + e.cost < cost[e.to.index]) {
                        cost[e.to.index] = cost[now.index] + e.cost;
                        q.offer(e.to);
                    }
                }
            }
            if (cost[0] == Integer.MAX_VALUE) continue;
            ans = Math.min(ans, cost[0] + edge.cost);
        }
        if (ans == Long.MAX_VALUE) out.ans(-1).ln();
        else out.ans(ans).ln();
    }

    private static class Node {
        int index;
        List<Edge> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }
    }

    private static class Edge {
        int index;
        long cost;
        Node to;

        Edge(int index, long cost, Node to) {
            this.index = index;
            this.cost = cost;
            this.to = to;
        }
    }
}
