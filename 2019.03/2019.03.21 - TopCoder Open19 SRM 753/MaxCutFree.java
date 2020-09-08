package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.List;

public class MaxCutFree {
    public int solve(int n, int[] a, int[] b) {
        int m = a.length;
        boolean[] f = new boolean[m];

        int components = n;
        IntUnionFind global = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            if (global.union(a[i], b[i])) {
                components--;
            }
        }

        for (int i = 0; i < m; i++) {
            IntUnionFind uf = new IntUnionFind(n);
            int c = n;
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                if (uf.union(a[j], b[j])) {
                    c--;
                }
            }
            if (c != components) {
                f[i] = true;
            }
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < m; i++) {
            if (f[i]) {
                nodes[a[i]].link.add(nodes[b[i]]);
                nodes[b[i]].link.add(nodes[a[i]]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].watched) {
                continue;
            }
            Ans h = nodes[i].dfs(null);
            ans += Math.max(h.with, h.without);
        }

        return ans;
    }

    private static class Node {
        private List<Node> link = new ArrayList<>();
        private boolean watched;
        private Ans dfs(Node parent) {
            this.watched = true;
            int with = 1, without = 0;
            for (Node n : link) {
                if (n == parent) {
                    continue;
                }
                Ans a = n.dfs(this);
                with += a.without;
                without += Math.max(a.with, a.without);
            }
            return new Ans(with, without);
        }
    }

    private static class Ans {
        private final int with, without;

        public Ans(int with, int without) {
            this.with = with;
            this.without = without;
        }
    }
}
