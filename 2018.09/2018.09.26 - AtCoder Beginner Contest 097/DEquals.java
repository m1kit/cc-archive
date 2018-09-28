package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.UnionFind;

import java.io.PrintWriter;
import java.util.Arrays;

public class DEquals {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[in.ints() - 1] = i;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            uf.union(in.ints() - 1, in.ints() - 1);
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (uf.find(i) == uf.find(p[i])) {
                ans++;
            }
        }
        out.println(ans);
    }
}
