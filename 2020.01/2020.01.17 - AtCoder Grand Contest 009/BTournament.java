package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BTournament {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 1; i < n; i++) nodes[in.ints() - 1].children.add(nodes[i]);
        out.ans(nodes[0].solve(0) - 1).ln();
    }

    private static class Node {
        List<Node> children = new ArrayList<>();

        int solve(int depth) {
            List<Integer> a = new ArrayList<>();
            for (Node child : children)
                a.add(child.solve(depth + 1));
            a.sort(Comparator.reverseOrder());
            int max = 1;
            for (int i = 0; i < a.size(); i++) {
                max = Math.max(max, a.get(i) + i + 1);
            }
            return max;
        }
    }
}
