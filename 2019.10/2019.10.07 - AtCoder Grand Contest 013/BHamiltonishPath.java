package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BHamiltonishPath {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i + 1);
        int x = 0, y = 1;
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            if (i == 0) {
                x = a;
                y = b;
            }
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }

        List<Integer> ans = new ArrayList<>();

        nodes[x].used = nodes[y].used = true;
        Node cur = nodes[x].expand();
        while (cur != null) {
            ans.add(cur.index);
            cur = cur.from;
        }

        nodes[y].expand();
        cur = nodes[y];
        while (cur != null) {
            ans.add(cur.index);
            cur = cur.to;
        }

        out.ans(ans.size()).ln();
        ans.forEach(out::ans);
        out.ln();
    }

    private static class Node {
        int index;
        List<Node> adj = new ArrayList<>();
        boolean used;

        Node from, to;

        Node(int index) {
            this.index = index;
        }

        Node expand() {
            for (Node node : adj) {
                if (!node.used) {
                    node.used = true;
                    node.from = this;
                    this.to = node;
                    return node.expand();
                }
            }
            return this;
        }
    }
}
