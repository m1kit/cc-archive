package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.ArrayList;
import java.util.List;

public class EBichromization {

    private static final int INF = 1_000_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] d = in.ints(n);
        Node[] nodes = new Node[n];
        Edge[] edges = new Edge[m];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i, d[i]);

        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            Edge e = new Edge(nodes[x], nodes[y]);
            edges[i] = e;
            nodes[x].adj.add(e);
            nodes[y].adj.add(e);
        }

        List<Node> origin = new ArrayList<>();
        outer:
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (Edge e : nodes[i].adj) {
                Node dest = e.other(nodes[i]);
                if (d[i] > dest.v) continue outer;
                else if (d[i] == dest.v) cnt++;
            }
            if (cnt == 0) {
                out.ans(-1).ln();
                return;
            }
            origin.add(nodes[i]);
        }

        for (Node start : origin) {
            if (start.c >= 0) continue;
            start.c = 0;
            start.dfs();
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i].c == -1) throw new RuntimeException("node " + i + " not vis");
            out.print(nodes[i].c == 0 ? 'B' : 'W');
        }
        out.ln();
        for (int i = 0; i < m; i++) {
            out.ans(edges[i].cost).ln();
        }
    }

    private static class Node {
        int index, v, c = -1;
        List<Edge> adj = new ArrayList<>();

        public Node(int index, int v) {
            this.index = index;
            this.v = v;
        }

        void dfs() {
            //System.out.println("Visited node " + index);
            for (Edge e : adj) {
                if (e.visited) continue;

                Node dest = e.other(this);
                if (dest.v == this.v) {
                    if (dest.c < 0) {
                        dest.c = 1 - this.c;
                        e.cost = this.v;
                        e.visited = true;
                        dest.dfs();
                    } else {
                        e.cost = INF;
                        e.visited = true;
                    }
                } else if (dest.v > this.v) {
                    if (dest.c < 0) {
                        dest.c = this.c;
                        e.cost = dest.v - this.v;
                        e.visited = true;
                        dest.dfs();
                    } else {
                        e.cost = INF;
                        e.visited = true;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", v=" + v +
                    '}';
        }
    }

    private static class Edge {
        Node x, y;
        int cost = INF;
        boolean visited;

        public Edge(Node x, Node y) {
            this.x = x;
            this.y = y;
        }

        private Node other(Node node) {
            if (this.x == node) return this.y;
            else return this.x;
        }

        @Override
        public String toString() {
            return x.index + " <=> " + y.index;
        }
    }

}
