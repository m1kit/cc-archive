package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class ATaroVsJiro {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.FIRST_SECOND_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long k = in.longs();
        Node.s = in.string();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].neg.add(nodes[b]);
            nodes[b].neg.add(nodes[a]);
        }

        // B先手 R後手
        outer:
        for (int i = 0; i < n; i++) {
            if (nodes[i].isRed()) {
                if (k % 2 == 0) {
                    out.noln();
                    continue;
                }
                if (nodes[i].hasBlueNeg()) {
                    out.yesln();
                    continue;
                }
                out.noln();
            } else {
                if (k % 2 == 0) {
                    boolean flag = false; //先手勝ち
                    for (Node n1 : nodes[i].neg) {
                        if (!n1.hasRedNeg()) {
                            flag = true;
                        }
                    }
                    out.ans(flag).ln();
                    continue;
                }
                if (nodes[i].hasBlueNeg()) {
                    out.yesln();
                    continue;
                }
                out.noln();
            }
        }
    }

    private static class Node {
        private static String s;
        int index;
        List<Node> neg = new ArrayList<>();
        private boolean[] dp;
        private boolean[] dp2;

        public Node(int index) {
            this.index = index;
        }

        public boolean hasRedNeg() {
            bake();
            return dp[0];
        }

        public boolean hasBlueNeg() {
            bake();
            return dp[1];
        }

        public boolean isRed() {
            return s.charAt(index) == 'R';
        }

        public void bake() {
            if (dp != null) return;
            dp = new boolean[2];
            for (Node node : neg) {
                if (s.charAt(node.index) == 'R') {
                    dp[0] = true;
                } else {
                    dp[1] = true;
                }
            }
        }
    }
}
