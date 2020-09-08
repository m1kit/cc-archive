package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.List;

public class No1207X {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        ModMath mod = new ModMath(MOD);
        int n = in.ints(), m = in.ints(), b = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1, z = in.ints();
            if (uf.find(x) == uf.find(y)) continue;
            uf.union(x, y);
            nodes[x].edges.add(new Edge(nodes[y], mod.pow(b, z)));
            nodes[y].edges.add(new Edge(nodes[x], mod.pow(b, z)));
        }
        nodes[0].dfs(null);
        long ans = 0;
        for (Node node : nodes) {
            for (Edge edge : node.edges) {
                if (edge.size == -1) continue;
                //System.out.println(edge.size + " : " + edge.cost);
                long p = edge.size * (long) (n - edge.size) % MOD;
                p *= edge.cost;
                ans += p % MOD;
            }
            ans %= MOD;
        }
        out.ans(ans).ln();
    }

    private static class Node {
        List<Edge> edges = new ArrayList<>();
        int size = -1;

        void dfs(Node from) {
            size = 1;
            for (Edge edge : edges) {
                if (edge.dest == from) continue;
                edge.dest.dfs(this);
                edge.size = edge.dest.size;
                size += edge.dest.size;
            }
        }
    }

    private static class Edge {
        Node dest;
        long cost;
        int size = -1;

        Edge(Node dest, long cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
