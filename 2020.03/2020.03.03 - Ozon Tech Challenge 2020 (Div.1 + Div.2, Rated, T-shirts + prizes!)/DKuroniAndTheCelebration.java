package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

public class DKuroniAndTheCelebration {

    private static final Random rand = new Random();

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        IntBinaryOperator query = (u, v) -> {
            out.ans('?').ans(u + 1).ans(v + 1).ln().flush();
            int res = in.ints();
            if (res == -1) System.exit(0);
            return res - 1;
        };
        IntConsumer ans = r -> out.ans('!').ans(r + 1).ln().flush();

        int n = in.ints();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes[x].children.add(nodes[y]);
            nodes[y].children.add(nodes[x]);
        }
        int r = rand.nextInt(n);
        nodes[r].make(null);
        Node root = nodes[r];

        loop: while (!root.children.isEmpty()) {
            Iterator<Node> it = root.children.iterator();
            while (it.hasNext()) {
                Node child = it.next();
                if (child.children.isEmpty()) continue;
                Node grandchild = child.children.get(rand.nextInt(child.children.size()));
                int res = query.applyAsInt(root.index, grandchild.index);
                if (res == root.index) {
                    it.remove();
                } else if (res == child.index) {
                    root = child;
                    child.children.remove(grandchild);
                } else if (res == grandchild.index) {
                    root = grandchild;
                } else throw new RuntimeException();
                continue loop;
            }

            if (root.children.size() >= 2) {
                Node x = root.children.get(rand.nextInt(root.children.size()));
                Node y = root.children.get(rand.nextInt(root.children.size()));
                while (x == y) y = root.children.get(rand.nextInt(root.children.size()));
                int res = query.applyAsInt(x.index, y.index);
                if (res == root.index) {
                    root.children.remove(x);
                    root.children.remove(y);
                } else if (res == x.index) {
                    ans.accept(x.index);
                    return;
                } else if (res == y.index) {
                    ans.accept(y.index);
                    return;
                } else throw new RuntimeException();
                continue loop;
            }

            int res = query.applyAsInt(root.index, root.children.get(0).index);
            if (res == root.index) {
                root.children.clear();
            } else {
                root = root.children.get(0);
            }
        }
        ans.accept(root.index);
    }

    private static class Node {
        int index, size;
        List<Node> children = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        int make(Node parent) {
            children.remove(parent);
            size = 1;
            for (Node child : children) size += child.make(this);
            return size;
        }
    }
}
