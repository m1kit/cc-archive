package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import java.util.ArrayList;

public class DTransitTreePath {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            long c = in.longs();
            nodes[a].neg.add(nodes[b]);
            nodes[a].dis.add(c);
            nodes[b].neg.add(nodes[a]);
            nodes[b].dis.add(c);
        }
        int q = in.ints(), k = in.ints() - 1;
        nodes[k].dfs(null, 0);
        for (int i = 0; i < q; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            out.ans(nodes[x].depth + nodes[y].depth).ln();
        }
    }

    private static class Node {
        private ArrayList<Node> neg = new ArrayList<>();
        private ArrayList<Long> dis = new ArrayList<>();
        Node parent;
        long depth;

        private void dfs(Node parent, long depth) {
            this.parent = parent;
            this.depth = depth;
            for (int i = 0; i < neg.size(); i++) {
                if (neg.get(i) != parent) {
                    neg.get(i).dfs(this, depth + dis.get(i));
                }
            }
        }
    }
}
