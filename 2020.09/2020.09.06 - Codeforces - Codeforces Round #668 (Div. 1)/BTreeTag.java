package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

import java.util.ArrayList;
import java.util.List;

public class BTreeTag {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        out.setBoolLabel(LightWriter2.BoolLabel.ALICE_BOB_FIRST_UP);
        int testCases = in.ints();
        test:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), a = in.ints() - 1, b = in.ints() - 1, da = in.ints(), db = in.ints();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) nodes[i] = new Node(i);
            for (int i = 1; i < n; i++) {
                int x = in.ints() - 1, y = in.ints() - 1;
                nodes[x].adj.add(nodes[y]);
                nodes[y].adj.add(nodes[x]);
            }
            // Alice can catch up with Bob
            if (da * 2 >= db) {
                out.yesln();
                continue test;
            }
            // Alice can reach everywhere (maybe unnecessary)
            if (nodes[0].getFarthest(null).getFarthest(null).dist <= 2 * da) {
                out.yesln();
                continue test;
            }
            // Alice can reach in first move
            nodes[a].getFarthest(null);
            if (nodes[b].dist <= da) {
                out.yesln();
                continue test;
            }
            out.noln();
        }
    }

    private static class Node {
        final int index;
        int dist;
        final List<Node> adj = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        Node getFarthest(Node from) {
            dist = from == null ? 0 : from.dist + 1;
            Node res = this;
            for (Node next : adj) {
                if (next == from) continue;
                Node t = next.getFarthest(this);
                if (t.dist > res.dist) res = t;
            }
            return res;
        }
    }
}
