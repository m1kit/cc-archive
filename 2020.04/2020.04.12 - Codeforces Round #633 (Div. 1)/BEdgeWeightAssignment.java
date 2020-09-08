package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.ArrayList;
import java.util.List;

public class BEdgeWeightAssignment {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].neighbor.add(nodes[y]);
            nodes[y].neighbor.add(nodes[x]);
        }
        Node root = nodes[0];
        while (root.neighbor.size() == 1) root = nodes[root.index + 1];
        int min = BitMath.count(root.min(null)) == 1 ? 1 : 3;

        root.max(null);
        out.ans(min).ans(root.value).ln();
    }

    private static class Node {
        final int index;
        int depth = 0, value = 0;
        List<Node> neighbor = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        int min(Node from) {
            this.depth = from == null ? 0 : from.depth + 1;
            int res = this.neighbor.size() > 1 ? 0 : (1 << (depth & 1));
            for (Node next : neighbor) {
                if (next == from) continue;
                res |= next.min(this);
            }
            return res;
        }

        void max(Node from) {
            if (this.neighbor.size() == 1) return;
            int leaves = 0;
            for (Node next : neighbor) {
                if (next == from) continue;
                next.max(this);
                this.value += next.value + 1;
                if (next.neighbor.size() == 1) leaves++;
            }
            this.value -= Math.max(0, leaves - 1);
        }
    }

}
