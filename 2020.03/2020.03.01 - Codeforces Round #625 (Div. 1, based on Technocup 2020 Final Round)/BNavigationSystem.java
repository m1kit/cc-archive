package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BNavigationSystem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].forward.add(nodes[y]);
            nodes[y].back.add(nodes[x]);
        }
        int s = in.ints();
        int[] p = in.ints(s);
        for (int i = 0; i < s; i++) p[i]--;

        Queue<Node> q = new ArrayDeque<>(), t = new ArrayDeque<>();
        nodes[p[s - 1]].dist = 0;
        q.offer(nodes[p[s - 1]]);
        for (int d = 1; !q.isEmpty(); d++) {
            while (!q.isEmpty()) {
                Node node = q.poll();
                for (Node x : node.back) {
                    if (x.dist >= 0) continue;
                    x.dist = d;
                    t.offer(x);
                }
            }
            while (!t.isEmpty()) q.offer(t.poll());
        }

        int min = 0, max = 0;
        for (int i = 0; i < s - 1; i++) {
            int cnt = 0;
            Node now = nodes[p[i]];
            for (Node next : now.forward) {
                if (now.dist == next.dist + 1) cnt++;
            }
            if (now.dist != nodes[p[i + 1]].dist + 1) {
                min++;
                max++;
            } else if (cnt >= 2) {
                max++;
            }
            //System.out.println(p[i] + " => " + p[i + 1] + " : " + cnt);
        }
        out.ans(min).ans(max).ln();
    }

    private static class Node {
        private int dist = -1;
        private final List<Node> forward = new ArrayList<>(), back = new ArrayList<>();
    }
}
