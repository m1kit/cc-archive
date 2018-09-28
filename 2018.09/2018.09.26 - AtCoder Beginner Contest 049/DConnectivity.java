package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Pair;
import jp.llv.atcoder.lib.structure.UnionFind;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DConnectivity {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints(), l = in.ints();
        UnionFind road = new UnionFind(n);
        for (int i = 0; i < k; i++) {
            road.union(in.ints() - 1, in.ints() - 1);
        }
        UnionFind rail = new UnionFind(n);
        for (int i = 0; i < l; i++) {
            rail.union(in.ints() - 1, in.ints() - 1);
        }
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count.merge(road.find(i) + 300_000L * rail.find(i), 1, (x, y) -> x + y);
        }
        for (int i = 0; i < n; i++) {
            out.println(count.get(road.find(i) + 300_000L * rail.find(i)));
        }
    }
}
