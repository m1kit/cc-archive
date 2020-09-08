package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class FGraphWithoutLongDirectedPaths {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        int[] u = new int[m], v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = in.ints() - 1;
            v[i] = in.ints() - 1;
            nodes[u[i]].neg.add(nodes[v[i]]);
            nodes[v[i]].neg.add(nodes[u[i]]);
        }

        try {
            for (int i = 0; i < n; i++) {
                if (nodes[i].state == null) {
                    nodes[i].state = false;
                    nodes[i].dfs();
                }
            }
            out.yesln();
            for (int i = 0; i < m; i++) {
                out.print(nodes[u[i]].state ? '0' : '1');
            }
            out.ln();
        } catch (IllegalStateException ex) {
            out.noln();
        }
    }

    private static class Node {
        private final List<Node> neg = new ArrayList<>();
        Boolean state = null;

        public void dfs() {
            for (Node ne : neg) {
                if (ne.state == state) {
                    throw new IllegalStateException();
                } else if (ne.state != null) {
                    continue;
                }
                ne.state = !state;
                ne.dfs();
            }
        }
    }
}
