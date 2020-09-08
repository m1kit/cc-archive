package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 1; i < n; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        nodes[0].dfs(null);
        out.ans((nodes[0].ans0 + nodes[0].ans1) % MOD).ln();
    }

    private static class Node {
        long ans0 = 1, ans1 = 1;
        final List<Node> adj = new ArrayList<>();

        void dfs(Node from) {
            for (Node node : adj) {
                if (node == from) continue;
                node.dfs(this);
                ans0 *= (node.ans0 + node.ans1);
                ans1 *= node.ans0;
                ans0 %= MOD;
                ans1 %= MOD;
            }
        }
    }
}
