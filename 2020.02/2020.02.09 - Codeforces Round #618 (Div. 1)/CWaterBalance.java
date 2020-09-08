package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.*;
import java.util.stream.IntStream;

public class CWaterBalance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(1, in.ints());
            while (!stack.isEmpty() && stack.peek().compareTo(node) > 0) {
                node.merge(stack.pop());
            }
            stack.push(node);
        }
        for (Node node : stack) {
            for (int i = 0; i < node.length(); i++) {
                out.ans(node.value(), 12).ln();
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int count;
        long sum;

        Node(int count, long sum) {
            this.count = count;
            this.sum = sum;
        }

        int length() {
            return count;
        }

        double value() {
            return sum / (double) length();
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(sum * o.length(), o.sum * length());
        }

        void merge(Node o) {
            this.count += o.count;
            this.sum += o.sum;
        }
    }
}
