package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DGourmetChoice {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n + m];
        for (int i = 0; i < n + m; i++) nodes[i] = new Node(i);
        char[][] tbl = new char[n][];
        for (int i = 0; i < n; i++) tbl[i] = in.string().toCharArray();

        IntUnionFind uf = new IntUnionFind(n + m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tbl[i][j] == '=') uf.union(i, n + j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tbl[i][j] == '=') continue;
                nodes[uf.find(i)].valid = nodes[uf.find(n + j)].valid = true;
                if (uf.find(i) == uf.find(n + j)) {
                    //System.out.println("DIFF EQUAL");
                    out.noln();
                    return;
                } else if (tbl[i][j] == '<') {
                    nodes[uf.find(i)].adj.add(nodes[uf.find(n + j)]);
                    nodes[uf.find(n + j)].incoming++;
                } else {
                    nodes[uf.find(n + j)].adj.add(nodes[uf.find(i)]);
                    nodes[uf.find(i)].incoming++;
                }
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < n + m; i++) if (nodes[i].incoming == 0) q.offer(nodes[i]);
        int cur = 1;
        while (!q.isEmpty()) {
            Queue<Node> nq = new ArrayDeque<>();

            while (!q.isEmpty()) {
                Node node = q.poll();
                node.order = cur;
                for (Node next : node.adj) {
                    if (next.valid && --next.incoming == 0) {
                        nq.offer(next);
                    }
                }
            }

            cur++;
            q = nq;
        }

        for (int i = 0; i < n + m; i++) {
            if (nodes[i].valid && nodes[i].incoming != 0) {
                //System.out.println("INCOMING 0 NODE " + i);
                out.noln();
                return;
            }
        }

        int[] ansA = new int[n], ansB = new int[m];
        int[] order = new int[n + m + 1];


        out.yesln();
        for (int i = 0; i < n; i++) {
            out.ans(nodes[uf.find(i)].order);
        }
        out.ln();
        for (int i = 0; i < m; i++) {
            out.ans(nodes[uf.find(n + i)].order);
        }
        out.ln();
    }

    private static class Node {
        int index;
        int incoming;
        boolean valid;
        int order = 0;
        List<Node> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }
    }
}
