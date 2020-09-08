package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BPackDrop {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            nodes[i].parent = nodes[in.ints()];
            nodes[i].parent.children.add(nodes[i]);
        }
        for (int i = 0; i < m; i++) {
            nodes[in.ints()].drop = in.ints();
        }
        Node.ans = 0;
        int v = nodes[0].dfs();
        Node.ans += v * nodes[0].children.size();
        out.ansln(Node.ans);
    }

    private static class Node {
        private static int ans = 0;

        private Node parent;
        private List<Node> children = new ArrayList<>();
        private int drop = -1;

        public int dfs() {
            if (children.isEmpty()) {
                return drop;
            }
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (Node child : children) {
                int d = child.dfs();
                sum += d;
                min = Math.min(min, d);
            }
            sum -= children.size() * min;
            ans += sum;
            return min;
        }
    }
}
