package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class COneStrokePath {

    private static final int MOD = (int) 1e9 + 7;
    private static int n;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        n = in.ints();
        int m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() -1;
            nodes[a].neg.add(nodes[b]);
            nodes[b].neg.add(nodes[a]);
        }

        nodes[0].dfs(new BitSet(n));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nodes[i].ans;
        }
        out.ansln(ans);
    }

    private static class Node {
        int index;
        List<Node> neg = new ArrayList<>();
        int ans = 0;

        public Node(int index) {
            this.index = index;
        }

        private void dfs(BitSet bs) {
            bs.set(index);
            if (bs.cardinality() == n) {
                ans++;
                return;
            }
            for (Node n : neg) {
                if (bs.get(n.index)) {
                    continue;
                }
                BitSet cl = (BitSet) bs.clone();
                n.dfs(cl);
            }
        }
    }
}
