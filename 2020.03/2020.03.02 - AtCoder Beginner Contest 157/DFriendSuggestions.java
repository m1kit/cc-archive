package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.List;

public class DFriendSuggestions {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), k = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        List<List<Integer>> friends = new ArrayList<>(n), blocked = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            friends.add(new ArrayList<>());
            blocked.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            uf.union(x, y);
            friends.get(x).add(y);
            friends.get(y).add(x);
        }
        for (int i = 0; i < k; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            blocked.get(x).add(y);
            blocked.get(y).add(x);
        }
        for (int i = 0; i < n; i++) {
            int ans = uf.size(i) - friends.get(i).size() - 1;
            for (int block : blocked.get(i)) {
                if (uf.find(block) == uf.find(i)) ans--;
            }
            out.ans(ans).ln();
        }
    }
}
