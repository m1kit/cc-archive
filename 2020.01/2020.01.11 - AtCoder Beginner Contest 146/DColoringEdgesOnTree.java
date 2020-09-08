package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class DColoringEdgesOnTree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        int[] x = new int[n - 1], y = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            x[i] = in.ints() - 1;
            y[i] = in.ints() - 1;
            nodes[x[i]].adj.add(nodes[y[i]]);
            nodes[y[i]].adj.add(nodes[x[i]]);
        }

        nodes[0].dfs(null);

        out.ans(Node.max).ln();
        for (int i = 0; i < n - 1; i++) {
            out.ans(nodes[x[i]].depth > nodes[y[i]].depth ? nodes[x[i]].color : nodes[y[i]].color).ln();
        }
    }

    private static class Node {
        private static int max = 0;
        int color, depth;
        List<Node> adj = new ArrayList<>();

        void dfs(Node from) {
            if (from != null) depth = from.depth + 1;
            int color = 1;
            for (Node node : adj) {
                if (node == from) continue;
                if (this.color == color) color++;
                node.color = color++;
                node.dfs(this);
            }
            max = Math.max(max, this.color);
        }
    }
}
