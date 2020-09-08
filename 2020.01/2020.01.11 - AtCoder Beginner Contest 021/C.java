package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), a = in.ints() - 1, b = in.ints() - 1, m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }

        Queue<Node> q = new ArrayDeque<>(n);
        nodes[b].dist = 0;
        q.offer(nodes[b]);
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (Node adj : node.adj) {
                if (adj.dist >= 0) continue;
                adj.dist = node.dist + 1;
                q.offer(adj);
            }
        }

        nodes[a].cnt = 1;
        q.offer(nodes[a]);
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (Node adj : node.adj) {
                if (adj.dist + 1 != node.dist) continue;
                adj.cnt += node.cnt;
                adj.cnt %= MOD;
                if (!adj.visited) q.offer(adj);
                adj.visited = true;
            }
        }
        out.ans(nodes[b].cnt).ln();
    }

    private static class Node {
        List<Node> adj = new ArrayList<>();
        int dist = -1;
        long cnt = 0;
        boolean visited = false;
    }
}
