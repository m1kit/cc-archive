package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FEhabAndTheBigFinale {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.enableAutoFlush();

        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.ints() - 1, v = in.ints() - 1;
            nodes[u].children.add(nodes[v]);
            nodes[v].children.add(nodes[u]);
        }
        nodes[0].setParent(null);
        //System.out.println(Arrays.toString(nodes));

        out.ans('d').ans(1).ln();
        int dist = in.ints();
        Node cur = nodes[0];
        List<Node> candidate = new ArrayList<>();
        outer:
        while (dist > 0) {
            //System.out.println("NOW " + cur.index + " " + dist);
            candidate.clear();
            for (Node child : cur.children) {
                if (child.maxDepth < dist || child == cur.parent) continue;
                candidate.add(child);
            }
            //System.out.println(candidate);

            if (candidate.isEmpty()) {
                //System.out.println(cur);
                //System.out.println(cur.children);
                throw new RuntimeException();
            } else if (candidate.size() == 1) {
                dist--;
                cur = candidate.get(0);
                continue;
            }
            out.ans('s').ans(cur.index + 1).ln();
            int next = in.ints() - 1;
            if (next == -2) return;
            for (Node child : candidate) {
                if (child.index == next) {
                    cur = child;
                    dist--;
                    continue outer;
                }
            }
            throw new RuntimeException();
        }
        out.ans('!').ans(cur.index + 1).ln();
    }

    private static class Node {
        int index;
        Node parent;
        List<Node> children = new ArrayList<>();
        int maxDepth;

        Node(int index) {
            this.index = index;
        }

        int setParent(Node parent) {
            this.parent = parent;
            for (Node child : children) {
                if (child == parent) continue;
                maxDepth = Math.max(maxDepth, child.setParent(this));
            }
            return ++maxDepth;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", maxDepth=" + maxDepth +
                    '}';
        }
    }
}
