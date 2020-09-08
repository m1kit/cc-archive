package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.math.geo.Vec2i;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.structure.unionfindtree.SemiPersistentUnionFind;

public class DStampRally {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        if (m == 0) {
            int q = in.ints();
            for (int i = 0; i < q; i++) {
                out.ansln(-1);
            }
            return;
        }
        SemiPersistentUnionFind uf = new SemiPersistentUnionFind(n);
        for (int i = 0; i < m; i++) {
            uf.union(in.ints() - 1, in.ints() - 1);
        }

        int queries = in.ints();
        for (int q = 0; q < queries; q++) {
            int x = in.ints() - 1, y = in.ints() - 1, z = in.ints();
            int min = 0, max = m + 1;
            while (max - min > 1) {
                int mid = (min + max) / 2;

                Vec2i a = uf.findWithSize(x, mid), b = uf.findWithSize(y, mid);
                int num = a.y;
                if (a.x != b.x) {
                    num += b.y;
                }
                if (num >= z) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            out.ansln(max);
        }
        //uf.debug();
    }
}
