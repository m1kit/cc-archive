package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.*;

public class ALinovaAndKingdom {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int n = in.ints(), k = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }
        nodes[0].dfs(null);
        IntroSort.sort(nodes, Comparator.comparing(node -> -node.c));
        //System.out.println(Arrays.toString(nodes));
        long ans = 0;
        for (int i = 0; i < n - k; i++) ans += nodes[i].c;
        out.ans(ans).ln();
    }

    private static class Node {
        int i, d, c, s = 1;
        List<Node> adj = new ArrayList<>();

        Node(int i) {
            this.i = i;
        }

        void dfs(Node from) {
            this.d = from == null ? 0 : from.d + 1;
            for (Node next : adj) {
                if (next == from) continue;
                next.dfs(this);
                s += next.s;
            }
            this.c = this.s - this.d - 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", d=" + d +
                    ", c=" + c +
                    ", s=" + s +
                    '}';
        }
    }
}
