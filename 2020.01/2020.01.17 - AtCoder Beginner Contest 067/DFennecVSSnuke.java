package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class DFennecVSSnuke {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }
        nodes[0].dfs(null);
        Node now = nodes[n - 1];
        while (now.parent != null && now.parent.depth > nodes[n - 1].depth / 2) {
            now = now.parent;
        }
        out.ans(n > now.size * 2 ? "Fennec" : "Snuke").ln();
    }

    private static class Node {
        List<Node> adj = new ArrayList<>();
        int depth;
        int size = 1;
        Node parent;
        void dfs(Node from) {
            if (from != null) {
                depth = from.depth + 1;
                parent = from;
            }
            for (Node child : adj) {
                if (from == child) continue;
                child.dfs(this);
                size += child.size;
            }
        }
    }
}
