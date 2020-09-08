package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        nodes[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[in.ints() - 1].children.add(nodes[i]);
        }
        out.ans(nodes[0].calc()).ln();
    }

    private static class Node {
        private final List<Node> children = new ArrayList<>();
        private final long calc() {
            if (children.size() == 0) return 1;
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for (Node child : children) {
                long p = child.calc();
                min = Math.min(min, p);
                max = Math.max(max, p);
            }
            return min + max + 1;
        }
    }
}
