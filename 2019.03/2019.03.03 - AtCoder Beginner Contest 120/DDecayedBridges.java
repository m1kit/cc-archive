package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.structure.UnionFind;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class DDecayedBridges {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints();
        UnionFind uf = new UnionFind(n);
        long[] siz = new long[n];
        Arrays.fill(siz, 1);

        Vec2i[] v2 = new Vec2i[m];
        for (int i = 0; i < m; i++) {
            v2[i] = new Vec2i(in.ints() - 1, in.ints() - 1);
        }
        ArrayUtil.reverse(v2, 0, m);

        long[] res = new long[m];
        long ans = n * (n - 1L) / 2;
        for (int i = 0; i < m; i++) {
            res[i] = ans;
            if (uf.find(v2[i].x) == uf.find(v2[i].y)) {
                continue;
            }
            long prod = siz[uf.find(v2[i].x)] * siz[uf.find(v2[i].y)];
            ans -= prod;

            long wa = siz[uf.find(v2[i].x)] + siz[uf.find(v2[i].y)];
            siz[uf.find(v2[i].x)] = 0;
            siz[uf.find(v2[i].y)] = 0;

            uf.union(v2[i].x, v2[i].y);
            siz[uf.find(v2[i].x)] = wa;
        }
        ArrayUtil.reverse(res, 0, m);

        //System.out.println(Arrays.toString(siz));

        out.ansln(res);
    }
}
