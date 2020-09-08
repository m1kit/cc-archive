package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.List;

public class FAsyaAndKittens {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        Node[] pool = new Node[n];
        for (int i = 0; i < n; i++) {
            pool[i] = new Node();
            pool[i].val = i + 1;
        }
        for (int i = 1; i < n; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            Node node = new Node();
            node.left = pool[uf.find(x)];
            node.right = pool[uf.find(y)];
            uf.union(x, y);
            pool[uf.find(x)] = node;
        }
        List<Integer> ans = new ArrayList<>();
        pool[uf.find(0)].dfs(ans);
        for (int i : ans) out.ans(i);
        out.ln();
    }

    private static class Node {
        Node left, right;
        int val;

        void dfs(List<Integer> res) {
            if (val != 0) {
                res.add(val);
            } else {
                left.dfs(res);
                right.dfs(res);
            }
        }
    }
}
