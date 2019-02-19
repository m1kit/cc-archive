package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.structure.UnionFind;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FMSTUnification {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        UnionFind uf = new UnionFind(n);
        Vec3i[] edges = new Vec3i[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Vec3i(in.ints() - 1, in.ints() - 1, in.ints());
        }
        MergeSort.sort(edges, Comparator.comparing(edge -> edge.z));
        int c = 0;
        List<Vec3i> focused = new ArrayList<>();
        int ans = 0;
        while (c < m) {
            focused.clear();
            int w = edges[c].z;
            while (c < m && edges[c].z == w) {
                if (uf.find(edges[c].x) != uf.find(edges[c].y)) {
                    focused.add(edges[c]);
                }
                c++;
            }
            for (Vec3i edge : focused) {
                if (uf.find(edge.x) == uf.find(edge.y)) {
                    ans++;
                } else {
                    uf.union(edge.x, edge.y);
                }
            }
        }
        out.ans(ans).ln();
    }
}
