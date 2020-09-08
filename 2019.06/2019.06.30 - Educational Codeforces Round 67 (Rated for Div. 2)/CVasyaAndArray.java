package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class CVasyaAndArray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints(), m = in.ints();
        Constraint[] constraints = new Constraint[m];
        for (int i = 0; i < m; i++) {
            constraints[i] = new Constraint(in.ints(), in.ints() - 1, in.ints() - 1);
        }
        IntUnionFind uf = new IntUnionFind(n);
        for (int i = 0; i < m; i++) {
            if (constraints[i].type == 0) continue;
            for (int j = constraints[i].l; j < constraints[i].r; j++) {
                uf.union(j, j + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (constraints[i].type == 1) continue;
            if (uf.find(constraints[i].l) == uf.find(constraints[i].r)) {
                out.noln();
                return;
            }
        }
        out.yesln();
        for (int i = 0; i < n; i++) {
            out.ans(n - uf.find(i));
        }
        out.ln();
    }

    private static class Constraint {
        int type, l, r;

        public Constraint(int type, int l, int r) {
            this.type = type;
            this.l = l;
            this.r = r;
        }
    }
}
