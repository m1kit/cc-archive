package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FLISOnTree {

    private static final long INF = (long) 1e15;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(in.longs());
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].neg.add(nodes[y]);
            nodes[y].neg.add(nodes[x]);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, INF);
        nodes[0].dfs(null, dp);
        for (int i = 0; i < n; i++) out.ans(nodes[i].ans).ln();
    }

    private static class Node {
        List<Node> neg = new ArrayList<>();
        long v, ans;

        Node(long v) {
            this.v = v;
        }

        void dfs(Node from, long[] dp) {
            int index = ArrayUtil.lowerBound(dp, v);
            long prev = dp[index];
            dp[index] = v;
            ans = ArrayUtil.lowerBound(dp, INF);
            for (Node next : neg) {
                if (next == from) continue;
                next.dfs(this, dp);
            }
            dp[index] = prev;
        }
    }
}
