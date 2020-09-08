package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;

public class EHopscotchAddict {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            nodes[in.ints() - 1].neg.add(nodes[in.ints() - 1]);
        }
        int s = in.ints() - 1, t = in.ints() - 1;

        int[][] dp = new int[3][n];
        ArrayUtil.fill(dp, -1);
        Queue<Cur> q = new ArrayDeque<>();
        q.offer(new Cur(nodes[s], 0));
        dp[0][s] = 0;
        while (!q.isEmpty()) {
            Cur cur = q.poll();
            int ns = (cur.step + 1) % 3;
            for (Node next : cur.node.neg) {
                if (dp[ns][next.index] >= 0) continue;
                dp[ns][next.index] = dp[cur.step][cur.node.index] + (ns == 0 ? 1 : 0);
                q.offer(new Cur(next, ns));
            }
        }
        out.ans(dp[0][t]).ln();
    }

    private static class Cur {
        Node node;
        int step;

        Cur(Node node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    private static class Node {
        int index;
        List<Node> neg = new ArrayList<>();

         Node(int index) {
            this.index = index;
        }
    }
}
