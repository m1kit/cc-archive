package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.graph.NodeLike;
import dev.mikit.atcoder.lib.graph.SCCDecomposition;
import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SCC {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < m; i++) {
            int x = in.ints(), y = in.ints();
            nodes[x].next.add(nodes[y]);
            nodes[y].prev.add(nodes[x]);
        }
        List<? extends Collection<Node>> groups = SCCDecomposition.decompose(nodes);
        out.ans(groups.size()).ln();
        for (Collection<Node> group : groups) {
            out.ans(group.size());
            for (Node node : group) out.ans(node.getIndex());
            out.ln();
        }
    }

    private static class Node implements NodeLike<Node> {
        final int index;
        final List<Node> next = new ArrayList<>();
        final List<Node> prev = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public Collection<Node> getNextNodes() {
            return next;
        }

        @Override
        public Collection<Node> getPrevNodes() {
            return prev;
        }
    }
}
