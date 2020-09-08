package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.graph.IntGraph;
import dev.mikit.atcoder.lib.graph.IntNodeSet;
import dev.mikit.atcoder.lib.graph.Node;
import dev.mikit.atcoder.lib.graph.shortestpath.Dijkstra;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;
import dev.mikit.atcoder.lib.structure.unionfindtree.UnionFind;

import java.util.*;

public class DOkabeAndCity {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), k = in.ints();
        Vec2i[] es = new Vec2i[k];
        for (int i = 0; i < k; i++) {
            es[i] = new Vec2i(in.ints(), in.ints());
        }

        int startIndex = -1;
        int goalIndex = -1;
        IntUnionFind uf = new IntUnionFind(k);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(es[i].x - es[j].x) + Math.abs(es[i].y - es[j].y) == 1) {
                    uf.union(i, j);
                }
            }
            if (es[i].x == 1 && es[i].y == 1) {
                startIndex = i;
            } else if (es[i].x == n && es[i].y == m) {
                goalIndex = i;
            }
        }

        int[] map = new int[k];
        Arrays.fill(map, -1);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            int j = uf.find(i);
            if (map[j] >= 0) {
                map[i] = map[j];
            } else {
                map[i] = map[j] = cur;
                cur++;
            }
        }

        int total = uf.size();
        if (goalIndex == -1) total++;
        Node[] nodes = new Node[total];
        for (int i = 0; i < total; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < k; i++) {
            int x = map[i];
            for (int j = 0; j < i; j++) {
                if (Math.abs(es[i].x - es[j].x) + Math.abs(es[i].x - es[j].x) == 1) continue;
                if (Math.abs(es[i].x - es[j].x) <= 2 || Math.abs(es[i].y - es[j].y) <= 2) {
                    int y = map[j];
                    if (x == y) continue;
                    if (nodes[x].neg.contains(nodes[y])) continue;
                    nodes[x].neg.add(nodes[y]);
                    nodes[y].neg.add(nodes[x]);
                }
            }
        }

        Node goalNode;
        if (goalIndex == -1) {
            goalNode = nodes[total - 1];
            for (int i = 0; i < k; i++) {
                if (es[i].x >= n - 1 || es[i].y >= m - 1) {
                    int y = map[i];
                    if (nodes[total - 1].neg.contains(nodes[y])) continue;
                    nodes[total - 1].neg.add(nodes[y]);
                    nodes[y].neg.add(nodes[total - 1]);
                }
            }
            //System.out.println("USING INSTANT NODE");
        } else {
            goalNode = nodes[map[goalIndex]];
        }


        Queue<Node> q = new ArrayDeque<>();
        Node startNode = nodes[map[startIndex]];
        startNode.dist = 0;
        q.offer(startNode);
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (Node next : node.neg) {
                if (next.dist >= 0) continue;
                next.dist = node.dist + 1;
                q.offer(next);
            }
        }

        out.ans(goalNode.dist).ln();
    }

    private static class Node {
        private final List<Node> neg = new ArrayList<>();
        int dist = -1;

        @Override
        public String toString() {
            return "Node{" +
                    "neg=" + neg.size() +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
