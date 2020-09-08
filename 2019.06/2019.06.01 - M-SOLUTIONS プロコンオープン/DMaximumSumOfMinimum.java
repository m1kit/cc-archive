package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DMaximumSumOfMinimum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].neg.add(nodes[y]);
            nodes[x].size++;
            nodes[y].neg.add(nodes[x]);
            nodes[y].size++;
        }
        int[] d = in.ints(n);
        IntroSort.sort(d);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.size));
        for (int i = 0; i < n; i++) {
            pq.offer(nodes[i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            Node t = pq.poll();
            t.w = d[i];
            ans += d[i] * (long) t.size;
            for (Node next : t.neg) {
                next.size--;
                if (next.w != 0) continue;
                pq.remove(next);
                pq.offer(next);
            }
        }
        out.ans(ans).ln();
        for (int i = 0; i < n; i++) {
            out.ans(nodes[i].w);
        }
        out.ln();
    }

    private static class Node {
        int index;
        int size;
        int w;
        List<Node> neg = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }
}
