package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CThREE {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] c = new int[3];
        for (int i = 1; i <= n; i++) c[i % 3]++;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(nodes[b]);
            nodes[b].adj.add(nodes[a]);
        }
        nodes[0].dfs(null);
        Queue<Node> p1 = new ArrayDeque<>(), p2 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (nodes[i].depth % 2 == 0) p1.offer(nodes[i]);
            else p2.offer(nodes[i]);
        }


        if (p1.size() < p2.size()) {
            Queue<Node> t = p1;
            p1 = p2;
            p2 = t;
        }
        //System.out.println(p1.size() + ", "+p2.size());

        if (p1.size() >= c[1] + c[2]) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) continue;
                p1.poll().value = i;
            }
            for (int i = 3; i <= n; i += 3) {
                if (p1.isEmpty()) p2.poll().value = i;
                else p1.poll().value = i;
            }
        } else {
            for (int i = 1; i <= n; i += 3) p1.poll().value = i;
            for (int i = 2; i <= n; i += 3) p2.poll().value = i;
            for (int i = 3; i <= n; i += 3) {
                if (p1.isEmpty()) p2.poll().value = i;
                else p1.poll().value = i;
            }
        }
        for (int i = 0; i < n; i++) {
            out.ans(nodes[i].value);
        }
        out.ln();
    }

    static class Node {
        int depth = -1, value;
        List<Node> adj = new ArrayList<>();

        void dfs(Node parent) {
            depth = parent == null ? 0 : parent.depth + 1;
            for (Node n : adj) {
                if (n == parent) continue;
                n.dfs(this);
            }
        }
    }
}
