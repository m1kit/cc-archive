package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CPaintTheTree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), k = in.ints();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) nodes[i] = new Node(i);
            for (int i = 1; i < n; i++) {
                int x = in.ints() - 1, y = in.ints() - 1;
                long w = in.longs();
                nodes[x].adj.add(new Edge(w, nodes[y]));
                nodes[y].adj.add(new Edge(w, nodes[x]));
            }
            nodes[0].dfs(null);
            nodes[0].dp(k);
            out.ans(Math.max(nodes[0].fullyUsed, nodes[0].remained)).ln();
        }
    }

    private static class Node {
        List<Edge> adj = new ArrayList<>();
        List<Edge> children = new ArrayList<>();

        long remained, fullyUsed;

        Node(int index) {

        }

        void dfs(Node from) {
            for (Edge edge : adj) {
                if (edge.dest == from) continue;
                edge.dest.dfs(this);
                children.add(edge);
            }
            adj.clear();
        }

        void dp(int k) {
            for (Edge child : children) child.dest.dp(k);
            // Sort by happiness
            children.sort(Comparator.comparing(edge -> -Math.max(0, edge.take() - edge.remove())));
            //System.out.println(children);

            for (int i = 0; i < children.size(); i++) {
                long take = children.get(i).take(), remo = children.get(i).remove();
                take = Math.max(take, remo);
                //System.out.println("Taking " + children.get(i) + " mean " + take + ":" + remo);
                if (i < k - 1) {
                    remained += take;
                    fullyUsed += take;
                } else if (i == k - 1) {
                    remained += remo;
                    fullyUsed += take;
                } else {
                    remained += remo;
                    fullyUsed += remo;
                }
            }

            //System.out.println("Node " + index + " rem=" + remained + " ful=" + fullyUsed);
        }
    }

    private static class Edge {
        long w;
        Node dest;

        Edge(long w, Node dest) {
            this.w = w;
            this.dest = dest;
        }

        long take() {
            return w + dest.remained;
        }

        long remove() {
            return Math.max(dest.fullyUsed, dest.remained);
        }
    }
}
