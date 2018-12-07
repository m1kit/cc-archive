package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class DPeopleOnALine {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};
    private static final int ORIGIN = 5 * 100_000_000;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = IntStream.range(0, n).mapToObj(i -> new Node(i + 1)).toArray(Node[]::new);
        for (int i = 0; i < m; i++) {
            int l = in.ints() - 1, r = in.ints() - 1, d = in.ints();
            nodes[l].edges.put(nodes[r], d);
            nodes[r].edges.put(nodes[l], -d);
        }
        try {
            for (int i = 0; i < n; i++) {
                dfs(nodes[i]);
            }
            out.println(YES);
        } catch (IllegalStateException ex) {
            out.println(NO);
        }
    }

    private static void dfs(Node node) {
        if (node.pos == null) {
            node.pos = ORIGIN;
        }
        for (Map.Entry<Node, Integer> e : node.edges.entrySet()) {
            if (e.getKey().pos == null) {
                e.getKey().pos = node.pos + e.getValue();
                dfs(e.getKey());
            } else if (e.getKey().pos != node.pos + e.getValue()) {
                throw new IllegalStateException("Unsatisfiable");
            }
        }
    }

    private static class Node {
        private final int index;
        private Integer pos;
        private final Map<Node, Integer> edges = new HashMap<>();

        public Node(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return index + "@" + pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return index == node.index;
        }

        @Override
        public int hashCode() {
            return index;
        }
    }
}
