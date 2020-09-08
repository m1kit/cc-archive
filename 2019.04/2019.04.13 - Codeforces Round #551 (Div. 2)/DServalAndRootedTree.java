package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class DServalAndRootedTree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = n;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, in.ints());
        }
        for (int i = 1; i < n; i++) {
            int p = in.ints() - 1;
            nodes[i].parent = nodes[p];
            if (nodes[p].children.isEmpty()) k--;
            nodes[p].children.add(nodes[i]);
        }

        int cnt = nodes[0].maximizeCnt();
        //System.out.println(k + ":" + cnt);
        out.ansln(k - cnt + 1);
    }

    private static class Node {
        int index;
        int type;
        Node parent;
        List<Node> children = new ArrayList<>();

        Node(int index, int type) {
            this.index = index;
            this.type = type;
        }

        int maximizeCnt() {
            if (children.size() == 0) {
                return 1;
            } else if (type == 0) { //min
                int res = 0;
                for (Node child : children) {
                    res += child.maximizeCnt();
                }
                return res;
            } else { //max
                int res = Integer.MAX_VALUE;
                for (Node child : children) {
                    res = Math.min(res, child.maximizeCnt());
                }
                return res;
            }
        }
    }
}
