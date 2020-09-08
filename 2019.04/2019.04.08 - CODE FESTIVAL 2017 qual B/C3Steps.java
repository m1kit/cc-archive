package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.*;

public class C3Steps {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        try {
            nodes[0].dfs(null, 0);
            long[] c = Node.cnt;
            out.ansln(c[0] * c[1] - m);
        } catch (RuntimeException ex) {
            out.ansln(n * (n - 1L) / 2 - m);
        }
    }

    private static class Node {

        private static long[] cnt = new long[2];
        int index;
        List<Node> adj = new ArrayList<>();
        int parity = -1;

        public Node(int index) {
            this.index = index;
        }

        private void dfs(Node from, int parity) {
            if (this.parity >= 0 && this.parity != parity) {
                throw new RuntimeException();
            } else if (this.parity >= 0) {
                return;
            }
            this.parity = parity;
            cnt[parity]++;
            for (Node node: adj) {
                node.dfs(this,(parity + 1) % 2);
            }
        }
    }
}
