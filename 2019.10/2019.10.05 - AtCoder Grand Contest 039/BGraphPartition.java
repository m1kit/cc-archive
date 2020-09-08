package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.*;

public class BGraphPartition {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[][] b = new char[n][];
        for (int i = 0; i < n; i++) b[i] = in.string().toCharArray();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (b[i][j] == '1') {
                    nodes[i].adj.add(nodes[j]);
                    nodes[j].adj.add(nodes[i]);
                }
            }
        }
        try {
            nodes[0].dfs(0);
        } catch (RuntimeException ignored) {
            out.ans(-1).ln();
            return;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] distance = new int[n];
            Arrays.fill(distance, -1);
            Queue<Node> q = new ArrayDeque<>();
            distance[i] = 0;
            q.offer(nodes[i]);
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (Node next : now.adj) {
                    if (distance[next.index] >= 0) continue;
                    distance[next.index] = distance[now.index] + 1;
                    q.offer(next);
                }
            }
            ans = Math.max(ans, IntMath.max(distance));
        }
        out.ans(ans + 1).ln();
    }

    private static class Node {
        int index;
        List<Node> adj = new ArrayList<>();
        int parity = -1;

        Node(int index) {
            this.index = index;
        }

        void dfs(int par) {
            if (parity >= 0 && par != parity) throw new RuntimeException();
            if (parity >= 0) return;
            parity = par;
            for (Node next : adj) {
                next.dfs(1 - par);
            }
        }
    }
}
