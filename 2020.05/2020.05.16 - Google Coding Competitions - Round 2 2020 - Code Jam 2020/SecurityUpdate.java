package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SecurityUpdate {

    private static final int INF = 1_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        Edge[] edges = new Edge[m];
        nodes[0] = new Node();
        nodes[0].t = 0;
        nodes[0].k = 0;
        nodes[0].done = true;
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            int x = in.ints();
            if (x < 0) nodes[i].k = -x;
            else nodes[i].t = x;
        }
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            edges[i] = new Edge(nodes[x], nodes[y]);
            nodes[x].edges.add(edges[i]);
            nodes[y].edges.add(edges[i]);
        }

        PriorityQueue<Visit> tq = new PriorityQueue<>(Comparator.comparing(v -> v.to.t)), kq = new PriorityQueue<>(Comparator.comparing(v -> v.to.k));
        for (Edge e : nodes[0].edges) {
            Node dest = e.other(nodes[0]);
            if (dest.k >= 0) kq.offer(new Visit(nodes[0], dest, e));
            else tq.offer(new Visit(nodes[0], dest, e));
        }
        int count = 1, time = 1;
        while (count < n) {
            if (!tq.isEmpty() && (kq.isEmpty() || kq.peek().to.k < count || tq.peek().to.t == time)) {
                time = tq.peek().to.t;
                int deltac = 0;
                while (!tq.isEmpty() && tq.peek().to.t == time) {
                    Visit v = tq.poll();
                    if (v.to.done || v.from.t == time) continue;
                    deltac++;
                    v.to.k = count;
                    v.to.done = true;
                    v.via.d = time - v.from.t;
                    for (Edge e : v.to.edges) {
                        Node dest = e.other(v.to);
                        if (dest.done) continue;
                        if (dest.k >= 0) kq.offer(new Visit(v.to, dest, e));
                        else tq.offer(new Visit(v.to, dest, e));
                    }
                }
                count += deltac;
                //System.out.println(deltac);
            } else {
                if (kq.isEmpty()) throw new RuntimeException();
                int k = kq.peek().to.k;
                while (!kq.isEmpty() && kq.peek().to.k == k) {
                    Visit v = kq.poll();
                    if (v.to.done || v.from.t == time) continue;
                    v.to.t = time;
                    v.to.done = true;
                    v.via.d = time - v.from.t;
                    for (Edge e : v.to.edges) {
                        Node dest = e.other(v.to);
                        if (dest.done) continue;
                        if (dest.k >= 0) kq.offer(new Visit(v.to, dest, e));
                        else tq.offer(new Visit(v.to, dest, e));
                    }
                    count++;
                }
                time++;
            }
        }

        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        out.cases(testNumber);
        for (int i = 0; i < m; i++) out.ans(edges[i].d);
        out.ln();
    }

    private static class Node {
        private int k = -1, t = -1;
        boolean done = false;
        List<Edge> edges = new ArrayList<>();
    }

    private static class Edge {
        final Node x, y;
        int d = INF;

        Edge(Node x, Node y) {
            this.x = x;
            this.y = y;
        }

        Node other(Node s) {
            return s == x ? y : x;
        }
    }

    private static class Visit {
        final Node from, to;
        final Edge via;

        Visit(Node from, Node to, Edge via) {
            this.from = from;
            this.to = to;
            this.via = via;
        }
    }
}
