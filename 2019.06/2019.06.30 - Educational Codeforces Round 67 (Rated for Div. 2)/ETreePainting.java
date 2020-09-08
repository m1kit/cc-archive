package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class ETreePainting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = Node.n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 1; i < n; i++) {
            int u = in.ints() - 1, v = in.ints() - 1;
            nodes[u].adj.add(nodes[v]);
            nodes[v].adj.add(nodes[u]);
        }
        nodes[0].dfs(null);
        out.ans(nodes[0].outgoing).ln();

        /*for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " in=" + nodes[i].incoming + " out=" + nodes[i].outgoing);
        }*/
    }

    private static class Node {
        private static int n;
        private  List<Node> adj = new ArrayList<>();

        long incoming, outgoing;

        int dfs(Node parent) {
            int count = 1;
            long maxOut = 0;
            for (Node next : adj) {
                if (next == parent) continue;
                int c = next.dfs(this);
                count += c;
                maxOut = Math.max(maxOut, next.outgoing + n - c - next.incoming);
                incoming += next.incoming;
            }
            if (count == 1) {
                outgoing = n;
                incoming = 1;
                return 1;
            }
            outgoing = maxOut + incoming;
            incoming += count;
            return count;
        }
    }
}
