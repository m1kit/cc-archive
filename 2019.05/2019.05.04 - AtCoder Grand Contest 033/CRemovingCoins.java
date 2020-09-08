package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CRemovingCoins {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.FIRST_SECOND_FIRST_UP);
        int n = in.ints();
        Node[] nodes = IntStream.range(0, n).mapToObj(Node::new).toArray(Node[]::new);
        for (int i = 1; i < n; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].neg.add(nodes[b]);
            nodes[b].neg.add(nodes[a]);
        }

        nodes[0].dfs(null, 0);
        Node maxNode = null;
        for (int i = 0; i < n; i++) {
            if (maxNode == null || nodes[i].d > maxNode.d) {
                maxNode = nodes[i];
            }
        }

        maxNode.dfs(null, 1);
        int len = 0;
        for (int i = 0; i < n; i++) {
            len = Math.max(len, nodes[i].d);
        }
        out.ans(len % 3 != 2).ln();
    }

    private static class Node {
        private final int index;
        private final List<Node> neg = new ArrayList<>();

        private int d = 0;

        public Node(int index) {
            this.index = index;
        }

        private void dfs(Node parent, int depth) {
            for (Node n : neg) {
                if (n == parent) continue;
                n.dfs(this, depth + 1);
            }
            d = depth;
        }
    }
}
