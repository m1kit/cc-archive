package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.sort.IntroSort;
import jp.llv.atcoder.lib.structure.UnionFind;

import java.util.Comparator;
import java.util.TreeSet;

public class DBuilt {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Vec3i[] xd = new Vec3i[n];
        for (int i = 0; i < n; i++) {
            xd[i] = new Vec3i(in.ints(), in.ints(), i);
        }
        Vec3i[] yd = xd.clone();
        IntroSort.sort(xd, Comparator.comparing(c -> c.x));
        IntroSort.sort(yd, Comparator.comparing(c -> c.y));
        Vec3i[] dx = new Vec3i[n - 1], dy = new Vec3i[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dx[i] = new Vec3i(xd[i + 1].x - xd[i].x, xd[i].z, xd[i + 1].z);
            dy[i] = new Vec3i(yd[i + 1].y - yd[i].y, yd[i].z, yd[i + 1].z);
        }
        IntroSort.sort(dx, Comparator.comparing(c -> c.x));
        IntroSort.sort(dy, Comparator.comparing(c -> c.x));
        UnionFind uf = new UnionFind(n);

        int i = 0, j = 0;
        long ans = 0;
        while (i < n - 1 || j < n - 1) {
            if (i < n - 1 && (j == n - 1 || dx[i].x <= dy[j].x)) {
                if (uf.find(dx[i].y) != uf.find(dx[i].z)) {
                    ans += dx[i].x;
                    uf.union(dx[i].y, dx[i].z);
                }
                i++;
            } else {
                if (uf.find(dy[j].y) != uf.find(dy[j].z)) {
                    ans += dy[j].x;
                    uf.union(dy[j].y, dy[j].z);
                }
                j++;
            }
            //System.out.println(ans);
        }
        out.ans(ans).ln();
    }
}
