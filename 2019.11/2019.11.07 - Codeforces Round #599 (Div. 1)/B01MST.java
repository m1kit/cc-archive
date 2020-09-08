package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class B01MST {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }

        int ans = 0;
        boolean[] connected = new boolean[n];
        Queue<Node> zerocost = new ArrayDeque<>();
        zerocost.offer(nodes[0]);
        TreeSet<Node> cost = new TreeSet<>();
        for (int i = 0; i < n; i++) cost.add(nodes[i]);
        for (int count = 0; count < n;) {
            while (!zerocost.isEmpty()) {
                Node node = zerocost.poll();
                if (connected[node.index]) continue;
                connected[node.index] = true;
                for (Node adj: node.adj) {
                    if (!connected[adj.index]) {
                        cost.remove(adj);
                        adj.paths++;
                        cost.add(adj);
                    }
                }
                count++;
            }
            while (!cost.isEmpty() && cost.first().paths < count) {
                Node node = cost.pollFirst();
                if (!connected[node.index]) {
                    zerocost.offer(node);
                }
            }
            while (!cost.isEmpty() && zerocost.isEmpty()) {
                Node node = cost.pollFirst();
                if (!connected[node.index]){
                    zerocost.offer(node);
                    ans++;
                }
            }
        }
        out.ans(ans).ln();
    }

    private static class Node implements Comparable<Node> {
        @Override
        public int compareTo(Node o) {
            if (paths == o.paths) return Integer.compare(index, o.index);
            return Integer.compare(paths, o.paths);
        }

        List<Node> adj = new ArrayList<>();
        int index;
        int paths;

        Node(int index) {
            this.index = index;
        }
    }
}
