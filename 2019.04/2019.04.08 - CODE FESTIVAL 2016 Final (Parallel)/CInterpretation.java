package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayList;
import java.util.List;

public class CInterpretation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints(), m = in.ints();
        IntUnionFind uf = new IntUnionFind(n);
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int k = in.ints();
            int[] la = in.ints(k);
            for (int j = 0; j < k; j++) {
                li.get(la[j] - 1).add(i);
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> l = li.get(i);
            for (int j = 1; j < l.size(); j++) {
                uf.union(l.get(j - 1), l.get(j));
            }
        }
        out.ansln(uf.size(0) == n);
    }
}
