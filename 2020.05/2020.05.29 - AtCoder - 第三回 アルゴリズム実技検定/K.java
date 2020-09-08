package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.stream.IntStream;

public class K {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        Node[] nodes = new Node[n], tables = new Node[n];
        for (int i = 0; i < n; i++) {
            tables[i] = new Node(-1);
            nodes[i] = new Node(i);
            tables[i].top = nodes[i];
            nodes[i].bottom = tables[i];
        }
        Node[] tops = nodes.clone();
        for (int i = 0; i < q; i++) {
            int from = in.ints() - 1, to = in.ints() - 1, x = in.ints() - 1;
            Node bottom = tops[to];
            tops[to] = tops[from];
            bottom.top = nodes[x];
            tops[from] = nodes[x].bottom;
            nodes[x].bottom.top = null;
            nodes[x].bottom = bottom;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Node now = tables[i].top;
            while (now != null) {
                ans[now.id] = i + 1;
                now = now.top;
            }
        }
        out.ansln(ans);
    }

    private static class Node {
        final int id;
        Node top, bottom;

         Node(int id) {
            this.id = id;
        }
    }
}
