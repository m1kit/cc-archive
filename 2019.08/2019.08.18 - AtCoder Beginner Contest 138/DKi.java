package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class DKi {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), q = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < n - 1; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        for (int i = 0; i < q; i++) {
            int p = in.ints() - 1, x = in.ints();
            nodes[p].value += x;
        }
        nodes[0].dfs(null, 0);
        for (int i = 0; i < n; i++) {
            out.ans(nodes[i].value).ln();
        }
    }

    private static class Node {
        int index;
        long value;
        List<Node> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        void dfs(Node from, long delta) {
            this.value += delta;
            for (Node node: adj) {
                if (node == from) continue;
                node.dfs(this, value);
            }
        }
    }
}
