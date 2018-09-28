package jp.llv.atcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.IntStream;

public class D {

    private static Node[] nodes;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        // 1. INPUT GRAPH
        int n = in.nextInt();
        nodes = IntStream.range(0, n).mapToObj(Node::new).toArray(Node[]::new);
        for (int i = 1; i < n; i++) {
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            nodes[x].rel.add(nodes[y]);
            nodes[y].rel.add(nodes[x]);
        }

        // 2. ORGANIZE TREE
        nodes[0].setParent(0, null);

        // 3. CACHE PARENTS
        for (int i = 1; i < 20; i++) {
            for (Node node : nodes) {
                Node mid = node.parents[i - 1];
                if (mid != null) {
                    node.parents[i] = node.parents[i - 1].parents[i - 1];
                }
            }
        }

        // 4. OUTPUT
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            out.println(calc(in.nextInt() - 1, in.nextInt() - 1));
        }
    }

    private int calc(int a, int b) {
        if (nodes[a].depth > nodes[b].depth) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        Node x = nodes[a], y = nodes[b];
        int d = y.depth - x.depth;
        for (int j = 0; d > 0; j++, d /= 2) {
            if (d % 2 != 0) {
                y = y.parents[j];
            }
        }

        Node lca;
        if (x == y) {
            lca = x;
        } else {
            for (int j = 19; j >= 0; j--) {
                if (x.parents[j] != y.parents[j]) {
                    x = x.parents[j];
                    y = y.parents[j];
                }
            }
            lca = x.parents[0];
        }
        return nodes[a].depth + nodes[b].depth - lca.depth * 2 + 1;
    }

    private static class Node {
        private final int id;
        private Node[] parents = new Node[20];
        private int depth = 0;
        private final Set<Node> rel = new HashSet<>();

        public Node(int id) {
            this.id = id;
        }

        private void setParent(int depth, Node parent) {
            this.depth = depth;
            this.parents[0] = parent;
            for (Node child : rel) {
                if (child != parent) {
                    child.setParent(depth + 1, this);
                }
            }
        }

        @Override
        public String toString() {
            return "(" + (id + 1) + ":" + depth + ")";
        }
    }
}
