package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DEvenRelation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int u = in.ints() - 1, v = in.ints() - 1, w = in.ints() % 2;
            if (w == 0) {
                nodes[u].zero.add(nodes[v]);
                nodes[v].zero.add(nodes[u]);
            } else {
                nodes[u].one.add(nodes[v]);
                nodes[v].one.add(nodes[u]);
            }
        }
        nodes[0].dfs( 0);
        for (int i = 0; i < n; i++) {
            out.ans(nodes[i].color).ln();
        }
    }

    private static class Node {
        List<Node> zero = new ArrayList<>(), one = new ArrayList<>();
        int color = -1;
        void dfs(int color) {
            this.color = color;
            for (Node next : zero) {
                if (next.color == -1) next.dfs(color);
            }
            for (Node next : one) {
                if (next.color == -1) next.dfs(1 - color);
            }
        }
    }
}
