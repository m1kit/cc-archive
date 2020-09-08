package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class C3Steps {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].adj.add(nodes[y]);
            nodes[y].adj.add(nodes[x]);
        }
        int[] cnt = new int[2];
        try {
            nodes[0].dfs(0, cnt);
            out.ans(cnt[0] * (long) cnt[1] - m).ln();
        } catch (RuntimeException ex) {
            out.ans(n * (n - 1L) / 2 - m).ln();
        }
    }

    private static class Node {
        List<Node> adj = new ArrayList<>();
        int p = -1;

        void dfs(int p, int[] cnt) {
            if (this.p >= 0) {
                if (this.p != p) throw new RuntimeException();
                return;
            }
            this.p = p;
            cnt[p]++;
            for (Node node : adj) {
                node.dfs(1 - p, cnt);
            }
        }
    }
}
