package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class DDoubleDots {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = IntStream.range(0, n).mapToObj(Node::new).toArray(Node[]::new);
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }
        Queue<Node> q = new ArrayDeque<>(n);
        nodes[0].from = 0;
        q.offer(nodes[0]);
        while (!q.isEmpty()) {
            Node from = q.poll();
            for (Node to : from.adj) {
                if (to.from >= 0) continue;
                to.from = from.index;
                q.offer(to);
            }
        }
        out.yesln();
        for (int i = 1; i < n; i++) out.ans(nodes[i].from + 1).ln();
    }

    private static class Node {
        private final int index;
        private final List<Node> adj = new ArrayList<>();
        private int from = -1;

        Node(int index) {
            this.index = index;
        }
    }
}
