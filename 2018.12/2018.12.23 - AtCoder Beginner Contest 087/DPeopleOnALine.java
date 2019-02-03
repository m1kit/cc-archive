package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.WeightedUnionFind;
import jp.llv.atcoder.lib.structure.vector.IntWeightedUnionFind;

import java.io.PrintWriter;

public class DPeopleOnALine {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        IntWeightedUnionFind uf = new IntWeightedUnionFind(n);
        int m = in.ints();
        for (int i = 0; i < m; i++) {
            int l = in.ints() - 1, r = in.ints() - 1, d = in.ints();
            if (!uf.union(l, r, (long) d)) {
                out.println(NO);
                return;
            }
        }
        out.println(YES);
    }
}
