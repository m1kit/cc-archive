package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BNumbersOnTree {

    private static final int MOD = (int) 1e9 + 7;
    private static int cnt = 1;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        Node[] nodes = new Node[n];
        Node parent = null;
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < n; i++) {
            int p = in.ints() - 1;
            if (p >= 0) nodes[p].children.add(nodes[i]);
            else parent = nodes[i];
            nodes[i].c = in.ints();
        }
        cnt = 1;
        try {
            parent.solve();
        } catch (RuntimeException ex) {
            out.noln();
            return;
        }
        out.yesln();
        for (int i = 0; i < n; i++) {
            out.ans(nodes[i].a);
        }
        out.ln();
    }

    private static class Node {


        int index;
        int c, a, sub = 1, min = Integer.MAX_VALUE;
        List<Node> children = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        void solve() {
            for (Node child : children) {
                child.solve();
                sub += child.sub;
                min = Math.min(min, child.min);
            }
            if (c >= sub) throw new RuntimeException();
            if (sub == 1) {
                a = min = cnt++;
            } else {
                increase(min + c);
                a = min + c;
                cnt++;
            }
        }

        void increase(int cond) {
            if (a >= cond) a++;
            for (Node child : children) child.increase(cond);
        }
    }
}
